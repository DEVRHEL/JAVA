/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahoahtml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


/**
 *
 * @author ThanhTien
 */
public class Stenogaryphy {
     public static Map tagHTML(Map<String, String> m)
    {
       m.put("type", "value");
        m.put("width", "height");
       m.put("name","content");
       m.put("align","valign");       
        return m;
    }
    public static String docfile() throws IOException {
        File file = new File("C:\\Users\\thanh\\OneDrive\\Desktop\\html\\KhongCoAttribute.html");
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
 
        String line = ""; String s="";
        while((line = reader.readLine()) != null){
            s+=line;
        }
        return s;
    }
     public static String decodetoASCII(String s)
    {
        String s2 = "";
        char nextChar;
        for(int i = 0; i <= s.length()-7; i += 8)
        {
             nextChar = (char)Integer.parseInt(s.substring(i, i+8), 2);
             s2 += nextChar;
        }
        return s2;
    }
    // cho hai giá trị start va end 
    // vòng lặp duyệt từ đầu đến cuối file 
    //charAt: trả về giá trị Char của chuỗi tại vị trí  được chỉ định
     public static ArrayList<String> tachcacthe(String s)
    {
        int start=0; int end=0;
        ArrayList<String> a=new ArrayList<>();
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='<')
            {
                start=i;
                for(int j=i+1; j<s.length(); j++)
                {
                    if(s.charAt(j)=='>')
                    {
                        end=j;
                        a.add(s.substring(start, end+1));
                        i=j;
                        break;
                    }
                    i=j;
                }
            }
        }
        return a;
    }
     public static ArrayList<String> loccacthekhongcothuoctinh(ArrayList<String> a)
    {
        for(int i=0; i<a.size(); i++)
        {
            if(a.get(i).contains("'") || a.get(i).contains("\"") || a.get(i).contains("="))
            {
            }
            else
            {
                a.remove(i);
                i--;
            }
        }
        return a;
    }
     public static ArrayList<String> laythuoctinhtrongthe(ArrayList<String> a)
    {
        for(int i=0; i<a.size(); i++)
        {
            Pattern tagPattern = Pattern.compile("[a-zA-Z]+=");
            Matcher m = tagPattern.matcher(a.get(i));
            String attr="";
            while(m.find())
            {
                attr+= m.group()+" ";// style= value=
            }
            a.set(i, attr.replaceAll("= ", " "));
        }
        return a;
    }
    public static void main(String[] args) throws IOException {
        String s=docfile();
        ArrayList<String> a=new ArrayList<>();
        //a=tachcacthe(s);
        a=tachcacthe(s);       
        a=loccacthekhongcothuoctinh(a);
        //System.out.println(a);
        a=laythuoctinhtrongthe(a);
        //a=loccacthekhongcothuoctinh(a);
       // System.out.println("KQ:"+s);
       
        Map<String, String> m=new HashMap<>();
        m=tagHTML(m); // type value =1 width heigh =1
        String encode="";
        
        for(int i=0; i<a.size(); i++)
        {
            String[] mattr=a.get(i).split(" ");
            for(int j=0; j<mattr.length-1; j++)
            {
                if(m.containsKey(mattr[j]) && (m.containsValue(mattr[j+1])))
                {
                    encode+="1";
                    j++;
                }
                else if(m.containsKey(mattr[j+1]) && (m.containsValue(mattr[j])))
                {
                    encode+="0";
                    j++;
                }
                
            }
        }
       
           // System.out.println("Tin da giau :" +decodetoASCII(encode));
             if (decodetoASCII(encode).equals("")) {
                 System.out.println("Khong co giau tin");
            } else {
                 System.out.println("File html có giấu tin ");
            }

        
    }
}

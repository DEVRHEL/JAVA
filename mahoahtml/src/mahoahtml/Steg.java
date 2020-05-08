/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahoahtml;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import static mahoahtml.Ma_hoa_html.laythuoctinhtrongthegiaima;



public class Steg {

    /**
     * @param args the command line arguments
     */
    public static Map tagHTML(Map<String, String> m)
    {
        m.put("type", "value");
        m.put("width", "height");
        m.put("charset", "content");
        m.put( "href", "rel");
        m.put("src", "alt");
        m.put("class", "id");
        m.put("align", "valign");
        //01101000 01100001 01111010
        return m;
    }
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
    public static String docfile() throws IOException {
        File file = new File("D:\\Tai Lieu Ky 4\\Cac Ky Thuat Giau Tin\\New folder (3)\\html\\mahoa6.html");
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
 
        String line = ""; String s="";
        while((line = reader.readLine()) != null){
            s+=line;
        }
        return s;
    }
    public static String shiftString(String s, int i, boolean kt)
    {
        // true is right shift
        // false is left shift
        if(kt==true)
        {
            for(int j=0; j<i; j++)
            {
                s=s.substring(s.length()-1)+s.substring(0,s.length()-1);
            }
        }
        else if(kt==false)
        {
            for(int j=0; j<i; j++)
            {
                s=s.substring(1,s.length())+s.substring(0,1);
            }
        }
        return s;
    }
    public static int bit(String keykp)
    {
        Character key =keykp.charAt(0);
        int sobitdich = 0;
        int ascii=(int)key;
        System.out.println("ascii ky tu dau cua key: "+ascii);
        if(ascii>64&&ascii<69||ascii>96&&ascii<101)
        {
                   sobitdich=1;
        }
        else if(ascii>68&&ascii<73||ascii>100&&ascii<105)
        {
            sobitdich=2;
        }
        else if(ascii>72&&ascii<77||ascii>104&&ascii<109)
        {
            sobitdich=3;
        }
         else if(ascii>76&&ascii<81||ascii>108&&ascii<113)
        {
            sobitdich=4;
        }
                 else if(ascii>80&&ascii<85||ascii>112&&ascii<117)
        {
            sobitdich=5;
        }
                 else if(ascii>84&&ascii<88||ascii>116&&ascii<120)
        {
            sobitdich=6;
        }
                 else if(ascii>87&&ascii<91||ascii>119&&ascii<123)
        {
            sobitdich=7;
        }
        return sobitdich;
    }
    public static String decodetoASCII(String s, int bitsh)
    {
        String s2 = "";
        char nextChar;
        for(int i = 0; i <= s.length()-7; i += 8)
        {
            String shift=shiftString(s.substring(i, i+8), bitsh, true);
            System.out.println("chuoi ky tu dau shift: "+shift);
            nextChar = (char)Integer.parseInt(shift, 2);
            s2 += nextChar;
        }
        return s2;
    }
    public static String filterASCII(String s)
    {
        String txt="";
        for(int i=0; i<s.length(); i++)
        {
            char p=s.charAt(i);
            int asciiVal = (int)p;
            System.out.println("val: " +asciiVal);
            if(asciiVal >= 32 && asciiVal <=126)
            {
                txt+=p;
            }
        }
        return txt;
    }
    public static void main(String[] args) throws IOException {

 
        String s=docfile();
        ArrayList<String> a=new ArrayList<>();
        a=tachcacthe(s);
        a=loccacthekhongcothuoctinh(a);
        a = laythuoctinhtrongthegiaima(a);
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
        System.out.println("Nhap key: ");
        // Nhap key
        Scanner sn= new Scanner(System.in);
        String keyy= sn.nextLine();
        int bitsh=bit(keyy);
        System.err.println("encode: "+encode);
        System.out.println(decodetoASCII(encode,bitsh));
        /*
        System.out.println("Nhap key: ");
        // Nhap key
        Scanner sn= new Scanner(System.in);
        String keyy= sn.nextLine();
        int bitsh=bit(keyy);
        System.err.println("encode: "+encode);
        System.out.println(decodetoASCII(encode,bitsh));
        String m1=decodetoASCII(encode, bitsh);
        m1=filterASCII(m1);
        System.out.println("KQ: " +m1);
        */
    }
}

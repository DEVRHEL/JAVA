/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steg;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


/**
 *
 * @author master
 */
public class Steg {

    /**
     * @param args the command line arguments
     */
    public static Map tagHTML(Map<String, String> m)
    {
       m.put("type", "value");
        m.put("width", "height");
       m.put("name","content");
       m.put("align","valign");
       
         
        return m;
    }
//    public static void getTAG() throws IOException
//    {
//        BufferedReader in = new BufferedReader(new FileReader("test.html"));
//        String line;
//        StringBuilder stringBuilder = new StringBuilder();
//        while ((line = in.readLine()) != null) {
//            stringBuilder.append(line);
//        }
//        String pageContent = stringBuilder.toString();
//        Pattern pattern = Pattern.compile("<(?!!)(?!/)\\s*([a-zA-Z0-9]+)(.*?)>");
//        Matcher matcher = pattern.matcher(pageContent);
//        while (matcher.find()) {
//            String tagName = matcher.group(1);
//            System.out.println("<" + tagName + ">");
//        }
//        in.close();
//    }
//    public static void getAttribute()
//    {
//        String testHtml = "xx <tag a =\"b\" c=  \'d\' e=f> contentssss </tag> zz";
//        Pattern tagPattern = Pattern.compile("<(\\S+?)(.*?)>(.*?)</\\1>");
//        //Pattern attValueDoubleQuoteOnly = Pattern.compile("(\\w+)=\"(.*?)\"");
//        //Pattern attValueAll = Pattern.compile("([\\w:\\-]+)(\\s*=\\s*(\"(.*?)\"|'(.*?)'|([^ ]*))|(\\s+|\\z))");
//        Matcher m = tagPattern.matcher(testHtml);
//        boolean tagFound = m.find(); // true
//        //String tagOnly = m.group(0);// <tag a ="b" c= 'd' e=f> contentssss </tag>
//        //String tagname = m.group(1);// tag
//        String attributes = m.group(2);// a ="b" c= 'd' e=f
//        //String content = m.group(3);// contentssss
//        //System.out.println("Tag Only   : " + tagOnly);
//        //System.out.println("Tag Name   : " + tagname);
//        System.out.println("Attributes : " + attributes);
//       // System.out.println("Content    : " + content);
////        //m = attValueDoubleQuoteOnly.matcher(attributes);
////        m = attValueAll.matcher(attributes);
////        while (m.find()) {
////              System.out.println(" >> " + m.group(0));
////        }
//    }
//    public static void tachcacthe()
//    {
//        String s="String s = <span><input style='font-weight:bold'>Hello team</input></span>";
//        int start=0; int end=0;
//        for(int i=0; i<s.length(); i++)
//        {
//            if(s.charAt(i)=='<')
//            {
//                start=i;
//                for(int j=i+1; j<s.length(); j++)
//                {
//                    if(s.charAt(j)=='>')
//                    {
//                        end=j;
//                        System.out.println(s.substring(start+1, end));
//                        i=j;
//                        break;
//                    }
//                    i=j;
//                }
//            }
//        }
//    }
    
    
    
    
    
    
    
//    public static void readFile(){
//		String fileName = "test.html";//bạn hãy thay đổi đường dẫn tới file của bạn
////		int []i ={0};//i là biến đếm xem chúng ta đã in tới dòng nào
//		try(Stream<String> stream = Files.lines(Paths.get(fileName),StandardCharsets.UTF_8)){//đưa về dạng chuẩn utf8
//			stream.forEach(line ->{
//				//line là từng dòng trong file, tại đây bạn có thể tương tác với nội dung của file. Ở đây, mình chỉ in ra nội dung của từng dòng
//
////				System.out.println(line +" is number line "+ i[0]++);//in ra cả nội dung file và dòng thứ mấy ta vừa in, bắt đầu từ 0
//				System.out.println(line);
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
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
        File file = new File("test.html");
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
    public static void main(String[] args) throws IOException {
/*
            cho doc file html tung dong
            moi dong dung regex lay attribute của tag
            lay string truoc dau = cua chuoi o buoc 2
            dua vao map so sanh
*/
 
        String s=docfile();
        ArrayList<String> a=new ArrayList<>();
        a=tachcacthe(s);
        
        a=loccacthekhongcothuoctinh(a);
         //System.out.println(a);
        a=laythuoctinhtrongthe(a);
        
       
        
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
       
            System.out.println("Tin da giau :" +decodetoASCII(encode));
        
        
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahoahtml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static mahoahtml.Ma_hoa_html.encodeBin;


/**
 *
 * @author VoAnhHao
 */
public class Mahoahtml {

    /**
     * @param args the command line arguments
     */
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
     public static ArrayList<String> thekhongcothuoctinh(ArrayList<String> a)
    {
        for(int i=0; i<a.size(); i++)
        {
            if(a.get(i).contains("'") || a.get(i).contains("\"") )
            {
                 a.remove(i);
                i--;
            }
            else
            {
               
            }
        }
        return a;
    }
      public static ArrayList<String> data( String s)
    {
          
        //              6                              37     44           57
        ArrayList<Integer> list =new ArrayList<>();
        ArrayList<String> listtext =new ArrayList<>();
        int start=0; int end=0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='<')
            {
                list.add(i);
                for(int j=i; j<s.length(); j++)
                {
                    if(s.charAt(j)=='>')
                    {
                        list.add(j+1);
                        i=j;
                        break;
                    }
                    i=j;
                }
            }
        }
        for (int i = 0; i < list.size(); i+=2)
        {
            listtext.add(s.substring(start,list.get(i)));
            start=list.get(i+1);
        }
       
        return listtext;
    }
      public static ArrayList<String> laythuoctinhtrongthe(String a)
    {
        ArrayList <String> b= new ArrayList<String>();
            
            //Pattern tagPattern = Pattern.compile("([a-zA-Z]+)(=['|\"]([a-zA-Z0-9#]+)?['|\"|\\.])");
          Pattern tagPattern = Pattern.compile("([a-zA-Z]+)(=['|\"]([a-zA-Z0-9#\\.]+)?['|\"])");
                    Matcher m = tagPattern.matcher(a);
                    while(m.find())
                    {
                        b.add(m.group());
                        
                    }
                    return b;
                    
    }
       public static StringBuilder encodeBin(String s)
    {
        byte[] bytes = s.getBytes();
  StringBuilder binary = new StringBuilder();
   for (byte b : bytes)
  {
     int val = b;
     for (int i = 0; i < 8; i++)
     {
        binary.append((val & 128) == 0 ? 0 : 1);
        val <<= 1;
     }
     binary.append(' ');
  }
        return binary;
    }
  
    public static String docMessage(){
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        return s;

    }
    public static String dich_trai_bit(String s, int i)
    {
        // true is right shift
        // false is left shift
       
        
            for(int j=0; j<i; j++)
            {
                s=s.substring(1,s.length())+s.substring(0,1);
            }
        
        return s;
    }
    public static String loaibokhoangtrang( String s1) {
       
        s1 = s1.replaceAll("\\s", "");
        return s1;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        String s="<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +

"	<title>Document</title>\n" +
"	<link rel=\"stylesheet\" href=\"mystyle.css\">\n" +
"</head>\n" +
"<body>\n" +
"	<hr>\n" +
"		<img src=\"cart.jpg\" alt=\"banner\">\n" +
"		<div class=\"scrollmenu\" id=\"idscrollmenu\">\n" +
"		  <a href=\"home1\" rel=\"next\">Home</a>\n" +
"		  <a href=\"news2\" rel=\"next\">News</a>\n" +
"		  <a href=\"contact3\" rel=\"next\">Contact</a>\n" +
"		  <a href=\"about4\" rel=\"next\">About</a>\n" +
"		  <a href=\"home5\" rel=\"next\">Home</a>\n" +
"		  <a href=\"news6\" rel=\"next\">News</a>\n" +
"		  <a href=\"contact7\" rel=\"next\">Contact</a>\n" +
"		  <a href=\"about8\" rel=\"next\">About</a>\n" +
"		  <a href=\"home9\" rel=\"next\">Home</a>\n" +
"		  <a href=\"news11\" rel=\"next\">News</a>\n" +
"		  <a href=\"contact22\" rel=\"next\">Contact</a>\n" +
"		  <a href=\"about33\" rel=\"next\">About</a>\n" +
"		  <a href=\"home44\" rel=\"next\">Home</a>\n" +
"		  <a href=\"news55\" rel=\"next\">News</a>\n" +
"		  <a href=\"contact66\" rel=\"next\">Contact</a>\n" +
"		  <a href=\"about77\" rel=\"next\">About</a>\n" +
"		  <a href=\"home88\" rel=\"next\">Home</a>\n" +
"		  <a href=\"news99\" rel=\"next\">News</a>\n" +
"		  <a href=\"contact23\" rel=\"next\">Contact</a>\n" +
"		  <a href=\"about24\" rel=\"next\">About</a>\n" +
"		  <a href=\"home25\" rel=\"next\">Home</a>\n" +
"		  <a href=\"news26\" rel=\"next\">News</a>\n" +
"		  <a href=\"contact27\" rel=\"next\">Contact</a>\n" +
"		  <a href=\"about28\" rel=\"next\">About</a>\n" +
"		</div>\n" +
"	<hr>\n" +
"	<div class=\"row\" id=\"45\">\n" +
"  <div class=\"column\" id=\"10\">\n" +
"    <img src=\"wedding.jpg\" alt=\"1\">\n" +
"    <img src=\"rocks.jpg\" alt=\"2\">\n" +
"    <img src=\"falls2.jpg\" alt=\"3\">\n" +
"    <img src=\"paris.jpg\" alt=\"4\">\n" +
"    <img src=\"nature.jpg\" alt=\"5\">\n" +
"    <img src=\"mist.jpg\" alt=\"6\">\n" +
"    <img src=\"paris.jpg\" alt=\"7\">\n" +
"  </div>\n" +
"  <div class=\"column\" id=\"8\">\n" +
"    <img src=\"underwater.jpg\" alt=\"9\">\n" +
"    <img src=\"ocean.jpg\" alt=\"10\">\n" +
"    <img src=\"wedding.jpg\" alt=\"11\">\n" +
"    <img src=\"mountainskies.jpg\" alt=\"12\">\n" +
"    <img src=\"rocks.jpg\" alt=\"13\">\n" +
"    <img src=\"underwater.jpg\" alt=\"14\">\n" +
"  </div>\n" +
"  <div class=\"column\" id=\"15\">\n" +
"    <img src=\"wedding.jpg\" alt=\"16\">\n" +
"    <img src=\"rocks.jpg\" alt=\"17\">\n" +
"    <img src=\"falls2.jpg\" alt=\"18\">\n" +
"    <img src=\"paris.jpg\" alt=\"19\">\n" +
"    <img src=\"nature.jpg\" alt=\"20\">\n" +
"    <img src=\"mist.jpg\" alt=\"21\">\n" +
"    <img src=\"paris.jpg\" alt=\"22\">\n" +
"  </div>\n" +
"</div>\n" +
"</body>\n" +
"</html>";
        String key1="f";
        
       Character key =key1.charAt(0);
        int sobitdich = 0;
        int ascii=(int)key;
        System.out.println(ascii);
        
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
        System.out.println("nhap mesa");
        String messa=docMessage();
 StringBuilder m2= encodeBin(messa);
 System.out.println("chuadich"+m2);
 String chuoinhiphan=m2.toString();
 String [] mangnhiphan=chuoinhiphan.split(" ");
 String chuoidadich="";
 for(int i=0;i<mangnhiphan.length;i++)
 {
    mangnhiphan[i]=dich_trai_bit(mangnhiphan[i], sobitdich);
     
 }
 for(int i=0;i<mangnhiphan.length;i++)
 {
    chuoidadich+=" "+mangnhiphan[i];
 }
 System.out.println("chuoidadich "+chuoidadich);
        String m3=loaibokhoangtrang(chuoidadich);
        System.out.println(m3);
        String[] M3=m3.split("");
        int[]Binary=new int[M3.length];
        for(int i=0;i<M3.length;i++)
        {
            Binary[i]=Integer.parseInt(M3[i]);
        }
                 ArrayList<String> a=new ArrayList<>();
        a=tachcacthe(s);
        
        a=loccacthekhongcothuoctinh(a);
        ArrayList<String> b= new ArrayList<>();
         ArrayList<String> c= new ArrayList<>();
         ArrayList<String> thedadoi= new ArrayList<>();
                for(int i=0;i<Binary.length ;i++)
                {
                    System.out.println(a.get(i)+"the chua doi");
                 b=laythuoctinhtrongthe(a.get(i));
                 
                 c=laythuoctinhtrongthe(a.get(i));
       
                   if(Binary[i]==0)
                   {
                       System.out.println(Binary[i]);
                       Collections.swap(b, 0, 1);
                   }
                   String a0=a.get(i).replace(c.get(0), "tam");
                 String a1=a0.replace(c.get(1), b.get(1));
                String a2=a1.replace("tam", b.get(0));
                
                 System.out.println(a2+"//");
              thedadoi.add(a2);
                   for(String temp: b){
       System.out.println(temp);
       
    }
                    for(String temp2: c){
       System.out.println(temp2);
                    }
                
                }
                for(String temp3: thedadoi){
       System.out.println(temp3);
                }
                for(String temp4:a)
                {
                   System.out.println(temp4+"thechuadoi"); 
                }
                
               ArrayList<String> listtext =new ArrayList<>();
     listtext=data(s);
     System.out.println(s);
     for(int i=0;i<thedadoi.size();i++)
     {
         s=s.replace(a.get(i),thedadoi.get(i));
     }
     
     System.out.println("String da ma hoa"+s);
      
    }
    
    
}

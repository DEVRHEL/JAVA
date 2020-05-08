/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahoahtml;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static mahoahtml.Mahoahtml.laythuoctinhtrongthe;

/**
 *
 * @author vanti
 */
public class kiemtrathuoctinh {

    /**
     * @param args the command line arguments
     */
    /*  public static boolean kiemtrathuoctinh(ArrayList<String> mangthe)
    {
        
        
        for(int i=0;i<mangthe.size();i++)
        {
            mangthuoctinh=laythuoctinhtrongthe(mangthe.get(i));
            
            if(((mangthuoctinh.get(0)).startsWith("type"))||((mangthuoctinh.get(0)).startsWith("width"))||((mangthuoctinh.get(0)).startsWith("href"))||((mangthuoctinh.get(0)).startsWith("charset"))||((mangthuoctinh.get(0)).startsWith("src"))||((mangthuoctinh.get(0)).startsWith("class")))
                    {
                     return true;   
                    }
            else
            {
                 return false;
            }
           
        }
          return false;
        
        
    }*/
     public static ArrayList<String> laycapthuoctinhtrongthe(String a)
    {
        ArrayList <String> arrcapthuoctinh= new ArrayList<String>();
            
            //Pattern tagPattern = Pattern.compile("([mangThe-zA-Z]+)(=['|\"]([mangThe-zA-Z0-9#]+)?['|\"|\\.])");
         // Pattern tagPattern = Pattern.compile("([mangThe-zA-Z]+)(=['|\"]([mangThe-zA-Z0-9#\\.]+)?['|\"])");
         Pattern tagPattern = Pattern.compile("([a-zA-Z]+)(=['|\"]([a-zA-Z0-9#\\.]+)?['|\"])(\\s[a-zA-Z]+)(=['|\"]([a-zA-Z|a-zA-Z0-9#\\.]+)?['|\"])?");
     
                    Matcher m = tagPattern.matcher(a);
                    
                    
                    while(m.find())
                    {
                        arrcapthuoctinh.add(m.group());
                        
                    }
                    return arrcapthuoctinh;
                    
    }
      
      
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<String>mangthe= new ArrayList<>();
        mangthe.add("<input type=\"text\" value=\"\">" );
        //mangthe.add("<input height=\"50px\" width=\"40px\";");
       // mangthe.add("<input height=\"50px\" width=\"40px\";");
      //  mangthe.add("<input height=\"50px\" width=\"40px\";");
        mangthe.add("<input type=\"text\" value=\"\">" );
        mangthe.add("<input type=\"text\" value=\"\">" );
        mangthe.add("<img src=\"\" alt=\"\">");
       mangthe.add("<img alt=\"\" src=\"\">");
        mangthe.add("<img alt=\"\" alt=\"\">");
        
        String a="";
        ArrayList<String>mangthuoctinh= new ArrayList<>();
         for(int i=0;i<mangthe.size();i++)
        {
           System.out.println(mangthe.get(i));
        }
         for(int i=0;i<mangthe.size();i++)
        {
            mangthuoctinh=laycapthuoctinhtrongthe(mangthe.get(i));
            
         
         
           for(String temp:mangthuoctinh)
       {
             System.out.println(temp);
             a+="_"+temp;
          }
         
            
        }
         String phantuloi="";
         String phantuloi2="";
         System.out.println(a);
         String []mangcapthuoctinh=a.split("_");
         for(int i=0;i<mangcapthuoctinh.length;i++)
         {
             System.out.println(mangcapthuoctinh[i]);
         }
          
          
           
           for(int i=0;i<mangcapthuoctinh.length;i++)
         {
             if(mangcapthuoctinh[i].startsWith("value")||mangcapthuoctinh[i].startsWith("height")||mangcapthuoctinh[i].startsWith("alt"))
             {
                 System.out.println("loi");
                 phantuloi+="_"+"loi";
             }
             else
             {
                 System.out.println("ko");
                 phantuloi+="_"+"ko";
             }
            
         }
           System.out.println(phantuloi);
         
           
           
        
            
            
           for(int i=0;i<mangcapthuoctinh.length;i++)
         {
             if(mangcapthuoctinh[i].endsWith("type")||mangcapthuoctinh[i].endsWith("width")||mangcapthuoctinh[i].endsWith("src"))
             {
                 System.out.println("loi");
                 phantuloi2+="_"+"loi";
             }
             else
             {
                 System.out.println("ko");
                 phantuloi2+="_"+"ko";
             }
            
         }
            System.out.println(phantuloi2);
         
             if(phantuloi.contains("loi")||phantuloi2.contains("loi"))
             {
                 System.out.println("file html ko hop le2");
             }
             else
             {
                  System.out.println("file html hop le2");
             }
    }
    
}

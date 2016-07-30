import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;

public class EditFile {
  static String strLastContent;
  static Encoder objEncode = new Encoder();
    public static void Save(String strFileName, String strContent) throws IOException{
          FileWriter out = null;
          try{
            File file = new File(strFileName);
            if (file.exists() && file.isFile()){
            load(strFileName);
            }
      if(strLastContent != null && !strLastContent.isEmpty())
      	  {
      	  }
         out = new FileWriter(strFileName,true);
         
		char[] charArray = strContent.toCharArray();
         int indx =0 , Length = charArray.length;
         while (indx < Length) {
            out.write(objEncode.Decode(charArray[indx++]));
         }
      
        }finally {
         if (out != null) {
            out.close();
         }
      }
    }
    
     public static String load( String inputFile) throws IOException {
     	 
     
		FileReader inputReader = null;
		strLastContent="";
		try{
			File file = new File(inputFile);
            if (file.exists() && file.isFile()){
				inputReader = new FileReader(inputFile);
				int c;
				while ((c = inputReader.read()) != -1) {
					strLastContent += String.valueOf(Character.toChars(objEncode.Decode(c)));
					}
				}
			}
			finally{
				if(inputReader != null){
					inputReader.close();
			}
		}
		return strLastContent;
	}
 /*  public static void copyWith1Byte(String input, String output) throws IOException
   {
      FileInputStream in = null;
      FileOutputStream out = null;

      try {
         in = new FileInputStream(input);
         out = new FileOutputStream(output);
         
         int c;
         while ((c = in.read()) != -1) {
            out.write(c);
         }
      }finally {
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      	}
   }*/
 public static void copyWith2Byte(String input, String output) throws IOException
   {
      FileReader in = null;
      FileWriter out = null;

      try {
         in = new FileReader(input);
         out = new FileWriter(output);
         
         int c;
         while ((c = in.read()) != -1) {
            out.write(c);
         }
      }finally {
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      }
   }
   
}
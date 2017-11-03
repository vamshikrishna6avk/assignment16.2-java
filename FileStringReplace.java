package filehandling;//created package as filehanding
 /* In here importing classes, which are belong from java.io.package
 */
//import keyword is used to import built-in and user defined package into our java source file. So that our class can refer a class that is in another package by directly 
import java.io.BufferedReader;//The Java.io.BufferedReader class reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.

import java.io.File;//The Java.io.File class is an abstract representation of file and directory pathnames.
import java.io.FileReader;//The Java.io.FileReader class is a convenience class for reading character files.
import java.io.FileWriter;//The Java.io.FileWriter class is a convenience class for writing character files.
import java.io.IOException; //This exception occurs when an IO operation has failed for some reason. It is also a checked exception which means that your program has to handle it.
 /**
  * Creating a class FileStringReplace and and 
  * stringReplace method and passing arguments
  *
  */
public class FileStringReplace//here taken class name as FileStringReplace
                             //classes are the basics of oops(object oriented programming language)
{    
    static void stringReplace(String filePath, String oldString, String newString)//Here static a keyword which identifies class related thing
	//void is used to define return type of the method,void means method wont return any value
    {
    	/**
    	 * In here creating object of file class 
    	 * and declaring of oldStringChange
    	 * 
    	 */
        File ModifyInfile = new File(filePath);
         
        String oldStringChange = "";
         /**
          *  creating instance of BufferedReader and initializing by null;
          *  and also creating instance of FileWriter and initializing by null;
          *  than creating a try and catch to handling exception 
          */
        BufferedReader buffReader = null;
        
        FileWriter fileWriter = null;
         
        try
        {
        	/**
        	 * in here initializing buffReader and in the 
        	 * BufferedReader constructor calling FileReader and 
        	 * passing ModifyInfile and than declaring variable than 
        	 * 
        	 */
        	buffReader = new BufferedReader(new FileReader(ModifyInfile));
             
            String line = buffReader.readLine();
             /**
              * In here i've created  a while loop to read every line
              * in this while loop assigning each line which 
              * will read from the file, to this 'line' variable 
              * to this checking file is null or not, 
              * if null out of the loop than print the file.
              */
            while ((line = buffReader.readLine())!= null) //using while loop
            {
            	oldStringChange = oldStringChange + line + System.lineSeparator();//oldstringchange
                 
                line = buffReader.readLine();//readLine
            }
             
            //Replacing old word with new word..
             
            String newContent = oldStringChange.replaceAll(oldString, newString);
             
            fileWriter = new FileWriter(ModifyInfile);//new filewriter
             
            fileWriter.write(newContent);//newContent
        }
        catch (IOException e)//catch IOException
        {
            e.printStackTrace();//method os class throwable of java.lang package
        }
        finally//final keyword
        {
            try
            {
                //Closing the resources
                 
            	buffReader.close();//closing buffReader
                 
            	fileWriter.close();//closing fileWriter
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
     /**
      * creating main method and calling 
      * stringReplace method and in constructor
      * passing path of the file and replacing 
      * word 'vamshi' to 'Krishna'  than printing the window console
      *         
      */
    public static void main(String[] args)//Here public is a access modifier which defines who can access this method
	//Here static a keyword which identifies class related thing
	//void is used to define return type of the method,void means method wont return any value
	//main is name of method,and to display
	//declares method String[]
	//String[]args means arguments will be passed into main method and says that main() as a parameter
    {
    	stringReplace("E:/File In Java/Demostring.txt", "vamshi", "krishna");//stringReplace
         
        System.out.println("\nYou've successfully replace specific String in text file");//system is used to return code
        //out is a static member
        //println is used to print text and gives output
    }
}
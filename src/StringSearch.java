import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSearch {
	
	static HashMap<String,Integer> hm=new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//findAllUsingIndex("test","testingtekdhfkjehdjkwahdjkwhadjkhawjksanbsmbmtestbjfbaczmbwmnstestjfhsbdkjagdfghjdsgfuksedtesttest");
		//findAllUsingPattern("test","testingtekdhfkjehdjkwahdjkwhadjkhawjksanbsmbmtestbjfbaczmbwmnstestjfhsbdkjagdfghjdsgfuksedtest");
		readFile("/Users/SwathiBala/Documents/data.txt");
	    printResult();
	}

	
	public static void readFile(String inputFile)
	{
	    BufferedReader br=null;
	    try{
	     String currentLine;
	     br=new BufferedReader(new FileReader(inputFile)); 
	     while((currentLine=br.readLine()) != null)
	     {
	         System.out.println(currentLine);
	         readLine(currentLine); // method to read the lines 
	     }
	    }
	    catch(Exception excep)
	    {
	        excep.printStackTrace();
	    }
	    finally
	    {
	        try{
	            if(br!=null)
	                br.close();
	        }
	        catch(IOException ioExcep){
	            ioExcep.printStackTrace();
	        }
	    }
	}

	public static void readLine(String inputLine)
	{
	    inputLine=inputLine.replace(".","").replace(",","");
	    String words[]=inputLine.split(" ");
	    if(words.length>1)
	    {
	        for(String val:words)
	        {
	        Integer count=hm.get(val);
	        hm.put(val,(count==null)?1:count+1);
	        }
	    }
	}

	private static void printResult()
	{
	    String longestWord="";
	    System.out.println("Word -> Count");
	    System.out.println("---------------");
	    //print hashmap
	    for(Entry value:hm.entrySet())
	    {
	        System.out.println(value.getKey()+" ->"+value.getValue());
	        String keyWord=(String)value.getKey();
	        int keyWordLength=keyWord.length();
	        // to get longest word
	        boolean stringCompare=String.valueOf(keyWord.charAt(0)).equalsIgnoreCase(String.valueOf(keyWord.charAt(keyWordLength-1)));
	        if(stringCompare && longestWord.length()<keyWordLength)
	        {
	           longestWord= keyWord;
	        }
	    }
	    //print longest word
	    System.out.println("Longest word that ends and starts with the same character:");
	    System.out.println("------------------------------------------------------------");
	    System.out.println(longestWord);
	}
	
	
	private static void findAllUsingPattern(String pattern, String source) {
		long start = System.nanoTime();
		List<Integer> idx = new ArrayList<Integer>();
		  Pattern ptrn = Pattern.compile(pattern);
		  Matcher mtch = ptrn.matcher(source);
		  while(mtch.find())
		   idx.add(mtch.start());
		long stop = System.nanoTime();
		System.out.println("Pattern: " + (stop-start));
	}

	private static void findAllUsingIndex(String pattern, String source) {
		long start = System.nanoTime();
		List<Integer> idx = new ArrayList<Integer>();
		  int shift = pattern.length();
		  int intIndex = source.indexOf(pattern),from=0;
		  while(intIndex!=-1)
		  {
			  from=intIndex+shift;
			  idx.add(intIndex);
			  intIndex=source.indexOf(pattern,from);
		  }
		  long stop = System.nanoTime();
		  System.out.println("I: " + (stop-start));
		  
	}

}

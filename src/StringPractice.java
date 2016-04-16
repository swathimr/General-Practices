import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StringPractice {

	public static boolean PalindromeWihtoutReverse(String value)
	{
		boolean returnValue =false;
		int half = (value.length()-1)/2;
		int end = value.length()-1;
		for(int i=0;i<half;i++)
		{
			if(value.charAt(i)==value.charAt(end))
			{
				returnValue =true;
				end--;
			}
			else
			{
				returnValue =false;
				break;
			}
		}
		return returnValue;
	}
	
	public static boolean PalindromeWithStringReverse(String Value)
	{
		boolean returnValue =false;
		String reversedValue = new StringBuffer(Value).reverse().toString();
		if(reversedValue.equalsIgnoreCase(Value))
		{
			returnValue =true;	
		}
		return returnValue;
	}
	
	public static boolean CheckAnagram(String first,String second)
	{
		char[] firstVal = first.toCharArray();
		char[] secondVal = second.toCharArray();
		Arrays.sort(firstVal);
		Arrays.sort(secondVal);
		return Arrays.equals(firstVal,secondVal);
	}
	
	//produces result a3b3c4
	private static void compressString(String string) {
		StringBuffer buffer = new StringBuffer();
		char current=string.charAt(0);
		buffer.append(current);
		int count=1;
		for(int i=1;i<string.length();i++)
		{
			if(current==string.charAt(i))
			{
				count=count+1;
				current=string.charAt(i);
			}
			else if(current!=string.charAt(i))
			{
				current=string.charAt(i);
				buffer.append(count);
				count=1;
				buffer.append(current);
			}
		}
		buffer.append(count);
		System.out.println(buffer);
		}
	
	private static List<String> getListOfAnagrams()
	{
		String[] strs={"abc","dog","cab","bca","god","odg"};
		HashMap<String, LinkedList<String>> dict = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedString = String.valueOf(chars);
            if (dict.containsKey(sortedString)) {
                dict.get(sortedString).add(s);
            } else {
                LinkedList<String> list = new LinkedList<>();
                list.add(s);
                dict.put(sortedString, list);
            }
        }
        List<String> ret = new LinkedList<>();
        for (LinkedList<String> list : dict.values()) {
            if (list.size() > 1)
                ret.addAll(list);
            
        }
        for(String val:ret)
        {
        	System.out.println(val);
        }
        return ret;
	}
	
	private static void balanceParanthesis()
	{
		Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println(isBalanced(scan.next().toCharArray()) ? "YES" : "NO");
        }
	}
	
	private static boolean isBalanced(char[] input)
	{
		boolean isBalanced=true;
		int index=0;
		Stack<Character> stack = new Stack<>();
		HashMap<Character,Character> hm=new HashMap<>();
		hm.put('{', '}');
		hm.put('(', ')');
		hm.put('[', ']');
		while(index<input.length && isBalanced==true)
		{
			char current=input[index];
			if(hm.containsKey(current))
			{
				stack.push(current);
			}
			else if(stack.isEmpty())
			{
				isBalanced=false;
			}
			else if(hm.containsValue(current))
			{
				char last=stack.pop();
				if(current==hm.get(last))
				{
					isBalanced=true;
				}
				else
				{
					isBalanced=false;
				}
			}
			index++;
		}
		if(!stack.isEmpty()){isBalanced=false;}
		return isBalanced;
	}
	
	public static void main(String[] args) {
		System.out.println("Palidnrome::"+PalindromeWihtoutReverse("masddsam"));
		System.out.println("Palidnrome::"+PalindromeWithStringReverse("masdgjhdsam"));
		System.out.println("CheckifAnagram::"+CheckAnagram("mark","karm"));
		getListOfAnagrams();
		compressString("aaabbbcccc");
		balanceParanthesis();
	}

}

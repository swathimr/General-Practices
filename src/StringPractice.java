import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class StringPractice {

	public static void main(String[] args) {
		System.out.println("Palidnrome::"+PalindromeWihtoutReverse("masdsam"));
		System.out.println("Palidnrome::"+PalindromeWithStringReverse("masdgjhdsam"));
		System.out.println("CheckifAnagram::"+CheckAnagram("mark","karm"));
		getListOfAnagrams();
		compressString("aabcccccaaa");
		//balanceParanthesis();
		longestPalindromeSubstring();
		System.out.println(isomorphicString("paper","title"));
		lengthOfLastWord();
		replaceAll();
		getFirstNonRepeatedChar();
		reverseVowels();
		stringPermutation("","JSP");
		System.out.println("String are rotated::"+isStringsareRotated());
		searchInRotatedArray();
		System.out.println("string are unique"+isUnique());
	}

	// time complexity o(n)
	private static boolean isUnique() {
		String input="test";
		if(input.length()>256)
			return false;
		boolean[] charset=new boolean[256];
		for(int i=0;i<input.length();i++)
		{
			int val=input.charAt(i);
			if(charset[val])
				return false;
			charset[val]=true;
		}
		return true;
	}

	//o(n^2) spacce complexity is o(1)
	private static String longestPalindromeSubstring() {
		String input="bb";
		if(input==null)
			return null;
		if(input.length()==1)
			return input;
		String longest=input.substring(0, 1);
		for(int i=0;i<input.length();i++)
		{
			//with center i
			String temp=helper(input,i,i);	
			if(temp.length()>longest.length())
				longest=temp;
			//with center i+1
			temp=helper(input, i, i+1);
			if(temp.length()>longest.length())
				longest=temp;	
		}
		System.out.println("longest palindrome is::"+longest);
		return longest;
	}

	private static String helper(String input, int start, int end) {
		while(start>=0 && end<input.length() && input.charAt(start)==input.charAt(end))
		{
			start--;
			end++;
		}
		return input.substring(start+1,end);
	}

	// time complexity o(logn)
	private static int searchInRotatedArray() {
		int nums[]={4,5,6,7,0,1,2};int target=1;
		
		int left=0;int right=nums.length-1;
        while(left<=right)
        {
            int mid=right+left/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>=nums[left])
            {
                if(nums[left]<=target && target<nums[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }
            else
            {
                if(nums[mid]<target && target<=nums[right])
                    left=mid+1;
                else
                    right=mid-1;
            }
        }
        return -1;
	}

	// check if one string is a rotation of other string
	private static boolean isStringsareRotated() {
		String s1="ABCD";
		String s2="CDAB";
		return (s1.length()==s2.length()&& ((s1+s1).indexOf(s2)!=-1));
	}

	// tentative time complexity O(n*n!) - n! permutations and n to print permutations
	private static void stringPermutation(String permutation,String str) {
		if(str.length()==0)
		{
			System.out.println(permutation);
		}
		else
		{
			for(int i=0;i<str.length();i++)
			{
				stringPermutation(permutation+str.charAt(i),str.substring(0,i)+str.substring(i+1,str.length()));	
			}
		}
	}
	

	private static void reverseVowels() {
		String input="estimate";
		ArrayList<Character> vowelList= new ArrayList<>();
		vowelList.add('A');
		vowelList.add('E');
		vowelList.add('I');
		vowelList.add('O');
		vowelList.add('U');
		vowelList.add('a');
		vowelList.add('e');
		vowelList.add('i');
		vowelList.add('o');
		vowelList.add('u');
		int i=0,j=input.length()-1;
		char[] inputArr=input.toCharArray();
		while(i<j)
		{
			if(!vowelList.contains(inputArr[i]))
			{
				i++;
				continue;
			}
			if(!vowelList.contains(inputArr[j]))
			{
				j--;
				continue;
			}
			char t=inputArr[i];
			inputArr[i]=inputArr[j];
			inputArr[j]=t;
			i++;
			j--;
		}
		System.out.println(new String(inputArr));
	}

	public static boolean PalindromeWihtoutReverse(String value)
	{
		value=value.replaceAll("//W+","").replaceAll("//s+","").toLowerCase();
		for(int i=0;i<value.length();i++)
		{
			if(value.charAt(i)!=value.charAt(value.length()-1-i))
				return false;
		}
		return true;
	}
	
	public static boolean PalindromeWithStringReverse(String Value)
	{
		boolean returnValue =false;
		String reversedValue = new StringBuffer(Value).reverse().toString();
		if(reversedValue.equalsIgnoreCase(Value))
		{
			returnValue =true;	
		}
		return Value.equals(new StringBuffer(Value).reverse().toString());
	}
	
	
	public static boolean CheckAnagram(String first,String second)
	{
		//anagram other method
		StringBuilder sb=new StringBuilder(second);
        for(int i=0;i<first.length();i++)
        {
            int index=sb.indexOf(""+first.charAt(i));
            if(index!=-1)
                sb.deleteCharAt(index);
            else
                return false;
        }
		
		
		// anagram using sort and equals n logn
		char[] firstVal = first.toCharArray();
		char[] secondVal = second.toCharArray();
		Arrays.sort(firstVal);
		Arrays.sort(secondVal);
		return Arrays.equals(firstVal,secondVal);
	
	}
	
	//produces result a3b3c4
	//o(n)
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
				buffer.append(count);
				count=1;
				current=string.charAt(i);
				buffer.append(current);
			}
		}
		buffer.append(count);
		System.out.println(buffer);
		}
	
	// time complexity - O(knlogn) kstrings of length n
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
	
	// time complexity o(n) auxillary spcae - o(n)
	private static void balanceParanthesis()
	{
		Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println(isBalanced(scan.next()) ? "YES" : "NO");
        }
	}
	
	private static boolean isBalanced(String s)
	{
		HashMap<Character,Character> hm=new HashMap<Character,Character>();
        hm.put('{', '}');
		hm.put('(', ')');
		hm.put('[', ']');
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++)
		{
		    char current=s.charAt(i);
		    if(hm.containsKey(current))
		    {
		        stack.push(current);
		    }
		    else if(hm.containsValue(current))
		    {
		        if(!stack.isEmpty() && hm.get(stack.peek())==current)
		            stack.pop();
		        else
		            return false;
		    }
		}
		return stack.isEmpty();
	}

	private static void getFirstNonRepeatedChar() {
		String input="geaks for geeks";
		char[] string=input.toCharArray();
		HashMap<Character,Integer> hm=new HashMap<>();

		for(int i=0;i<input.length();i++)
		{
			if(hm.containsKey(string[i]))
			{
				hm.put(string[i], hm.get(string[i])+1);
			}
			else
				hm.put(string[i], 1);
		}
		for(int i=0;i<string.length;i++)
		{
			if(hm.get(string[i])==1)
			{
				System.out.println("The first non repeated character is::"+string[i]);
				return;
			}
		}
		
		//in one pass
		Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
	}

	//time complexity  -O(n)
	private static boolean isomorphicString(String string1, String string2) {
		if(string1.length()!=string2.length())
			return false;
		else
		{
			HashMap<Character, Character> hm=new HashMap<>();
			for(int i=0;i<string1.length();i++)
			{
				char char1=string1.charAt(i);
				char char2= string2.charAt(i);
				if(hm.containsKey(char1)){
					if(hm.get(char1)==char2)
					{
						continue;
					}
					else
						return false;
				}
				else if(hm.containsValue(char2))
					return false;
				hm.put(char1, char2);
			}
			return true;
		}
	}

	private static void lengthOfLastWord() {
		String str="";
		String val[]=str.split(" ");
		if(val.length>1)
		{
			System.out.println(val[val.length-1]);
		}
		else
		{
			System.out.println("0");
		}
	}

	//custom replace all emthod implementation
		private static void replaceAll() {
			String str1="hello";
			String str2="helloworldhell ";
			char[] str1char=str1.toCharArray();
			char[] str2char=str2.toCharArray();
			StringBuilder sb=new StringBuilder();
			int j=0;
			for(int i=0;i<str2.length();i++)
			{
				if(j!=str1.length()&&str1char[j]==str2char[i])
				{
						j++;
				}
				else
				{
					j=0;
					sb.append(str2char[i]);
				}
			}
			System.out.println(sb.toString());
		}
		
}

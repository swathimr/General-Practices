import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RandomPractise {

	public static void main(String[] args) {
		fizzbuzz();
		findDuplicatesArrayList();
		reverseInteger();
		swapWithoutTemp();
		findMissingNumber();
		findMaxInArray();
		UnionIntersectionSortedArrays();
		reverseArray();
		checkMapsEqual();
		CheckAnagram("mark","karm");
		PalindromeWihtoutReverse("masddsam");
		PalindromeWithStringReverse("masdgjhdsam");
	}

	// O(m+n) length of both the arrays
	private static void UnionIntersectionSortedArrays() {
		int[] arr1 = {1, 3, 4, 5, 7};
		int[] arr2= {2, 3, 5, 6};
		int i=0,j=0;
		
		//union implementation
		// intersection is same, print only if both values are same
		while(i<arr1.length && j<arr2.length)
		{
			if(arr1[i]<arr2[j])
			{
				System.out.print(arr1[i]);
				i++;
			}
			else if(arr2[j]<arr1[i])
			{
				System.out.print(arr2[j]);
				j++;
			}
			else if(arr1[i]==arr2[j])
			{
				System.out.print(arr1[i]);
				i++;j++;
			}
		}
		
		// not needed for intersection
		while(i<arr1.length)
		{
			System.out.println(arr1[i]);
			i++;
		}while(j<arr2.length)
		{
			System.out.println(arr2[j]);
			j++;
		}
		
	}
	
	//log n
	private static void reverseArray()
	{
		int[] myArray ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for(int i=0;i<myArray.length/2;i++)
		{
			int temp =myArray[i];
			myArray[i]=myArray[myArray.length-1-i];
			myArray[myArray.length-1-i]=temp;
		}
		for(int num:myArray)
		{
		System.out.print(num);
		}
	}

	private static void findMaxInArray() {
		int[] myArray = new int[]{1, 3, 8, 5, 7};
		Arrays.sort(myArray);
		System.out.println("Maximum value in array using sort:"+myArray[myArray.length-1]);
		
		int[] myArray1= new int[]{1, 3, 8, 5, 7};
		int maxVal = myArray1[0];
		for(int i=1;i<myArray1.length;i++)
		{
			if(myArray1[i]>maxVal)
			{
				maxVal=myArray1[i];
			}
		}
		System.out.println("Maximum value in array::"+maxVal);
	}

	private static void findMissingNumber() {
		//to find one number
		int[] iArray = new int[]{1, 2, 3, 5};
		int n=5;
		int expected = n*((n+1)/2);
		int sum=0;
		for(int i:iArray)
		{
			sum=sum+i;
		}
		int missingValue=expected-sum;
		System.out.println("Missing number::"+missingValue);
		// more than one missing number
	}

	private static void swapWithoutTemp() {
		int a = 10;
        int b = 20;
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("Swapped variables::A::"+a+",B::"+b);
	}

	private static void reverseInteger() {
		int value = -1235;
		int last =0;
		int reverse=0;
		boolean neg=false;
		if(value<0)
		{
			value=value*-1;
			neg=true;
		}
		while(value>=1)
		{
			last=value%10;
			reverse=reverse*10+last;
			value=value/10;
		}
		System.out.print("Reverese integer is::");
		System.out.println((neg==true)?reverse*-1:reverse);
	}

	private static void findDuplicatesArrayList() {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		names.add("cat");
		names.add("dog");
		names.add("cat");
		names.add("cow");
		names.add("dog");
		names.add("cat");
		names.add("cow");
		names.add("hen");
		
		//using hashset
		Set<String> temp = new HashSet();
		Set<String> setToReturn = new HashSet();
		for(String name:names)
		{
			if(!temp.add(name))
			{
				setToReturn.add(name);
			}
		}
		System.out.println(setToReturn);
		
		//using hashmap
		HashMap<String,Integer> hm=new HashMap<>();
		for(String name:names)
		{
			Integer count = hm.get(name);	
			hm.put(name, (count==null)?1:count+1);
		}
		for(Entry val:hm.entrySet() )
		{
			System.out.println("key::"+val.getKey()+",Value:::"+val.getValue());
		}
	}

	private static void fizzbuzz() {
		for(int i=1;i<=100;i++)
		{
			if(i%15==0)
			{
				System.out.println("Gizz");
			}
			else if(i%3==0)
			{
				System.out.println("Fizz");
			}
			else if(i%5==0)
			{
				System.out.println("Buzz");
			}
			/*else
			{
				System.out.println(i);
			}*/
		}
	}
	
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
	
	private static void checkMapsEqual()
	{
		Map map = new HashMap();
		map.put("AA","aaa");
		map.put("BB","bbb");
		map.put("CC","ccc");
		map.put("DD","ddd");

		Map map2 = new HashMap();
		map2.put("BB","bbb");
		map2.put("AA","aaa");
		map2.put("DD","ddd");
		map2.put("CC","ccc");

		if(map.equals(map2))
		{
		    System.out.println("Eql");
		}
		else
		{
		    System.out.println("Not");
		}
	}

}

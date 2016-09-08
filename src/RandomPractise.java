import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class RandomPractise {

	public static void main(String[] args) {
		fizzbuzz();
		findDuplicatesArrayList();		
		findMaxInArray();
		UnionIntersectionSortedArrays();
		reverseArray();
		checkMapsEqual();
		System.out.println("Merging two sorted list");
		mergeTwosortedLists();
		System.out.println();
		eqlibriumIndexOfArray();
		bullsAndCows();
		intersectionOfTwoArrays(); // unsorted;
		maximumSubArray();
		buyAndSellStock();
		wordBreak();
		ReversePolishNotation();
		System.out.println("no of trailing zeroes are::"+trailingZeroes(10));
		System.out.println("Peak element from the array is::"+peakElement());
		findMinMaxInArray();
	}

	// finds max and min in an array lesser comparisons
	private static void findMinMaxInArray() {
		int a[]={5,1,4,-1,6,2,0};
		if (a == null || a.length < 1)
			return;
	 
		int min,max;
		if(a[0]>a[1]){
			max=a[0];
			min=a[1];
		}
		else
		{
			max=a[1];
			min=a[1];
		}
		for(int i=2;i<a.length-2;i++){
			if(a[i]>a[i+1])
			{
				max=Math.max(a[i],max);
				min=Math.min(a[i+1],min);
			}
			else
			{
				max=Math.max(a[i+1],max);
				min=Math.min(a[i],min);
			}
			i+=2;
		}
		if (a.length % 2 == 1) {
			min = Math.min(min, a[a.length - 1]);
			max = Math.max(max, a[a.length - 1]);
		}
		System.out.println("min: " + min + "\nmax: " + max);	
	}

	private static int peakElement() {
		int[] num={1, 2, 3, 1};
		int max = num[0];
        int index = 0;
        for(int i=1; i<=num.length-2; i++){
            int prev = num[i-1];
            int curr = num[i];
            int next = num[i+1];
 
            if(curr > prev && curr > next && curr > max){
                index = i;
                max = curr;
            }
        }
 
        if(num[num.length-1] > max){
            return num.length-1;
        }
 
        return index;
	}

	private static int trailingZeroes(int n) {
		 if (n < 0)
			    return -1;
	        int count=0;
	     for(long i=5;n/i>=1;i *=5)
	     {
	         count += n/i;
	     }
	     return count;
	}

	private static int ReversePolishNotation() {
		String[] tokens={"2", "1", "+", "3", "*"};
		String token="+-*/";
        Stack<String> stack=new Stack<String>();
        int returnValue=0;
        for(String t:tokens)
        {
            if(!token.contains(t))
                stack.push(t);
            else
            {
                int a=Integer.valueOf(stack.pop());
                int b=Integer.valueOf(stack.pop());
                int index=token.indexOf(t);
                switch(index){
                    case 0:
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b-a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a*b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }
        returnValue=Integer.valueOf(stack.pop());
        System.out.println("Reverse Polish Notation"+returnValue);
        return returnValue;
	}

	//O(n^2)
	private static void wordBreak() {
		String s="catsanddog";
		HashSet dict=new HashSet();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		int[] arr=new int[s.length()+1];
		Arrays.fill(arr, -1);
		arr[0]=0;
		System.out.println("Word Break PArt 1 :::");
		for(int i=0;i<s.length();i++)
		{
			if(arr[i]!=-1)
			{
				for(int j=i+1;j<=s.length();j++)
				{
					String sub=s.substring(i, j);
					if(dict.contains(sub))
						System.out.println(sub);
						arr[j]=i;
				}
			}
		}
		System.out.println(Arrays.toString(arr)+"words can be broken:::"+String.valueOf(arr[s.length()]!=-1));
	}


	private static void buyAndSellStock() {
		int prices[]={7, 1, 5, 3, 6, 4};
		int result=0;
		int min=prices[0];
		for(int i=0;i<prices.length;i++)
		{
			result=Math.max(result, prices[i]-min);
			min=Math.min(prices[i],min);
		}
		System.out.println("Maximim profit obtained is "+result);
	}


	private static void maximumSubArray() {
		int[] arr={-2,1,-3,4,-1,2,1,-5,4};
		int sum=arr[0];
		int max=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			sum=Math.max(sum+arr[i],arr[i]);
			max=Math.max(max, sum);
		}
		System.out.println("maximun added element foudn is"+max);
	}


	// olog n
	private static Set<Integer> intersectionOfTwoArrays() {
		int[] nums1 = {1, 2, 2, 1},nums2 = {2, 2};
		HashSet<Integer> set1=new HashSet<Integer>();
	       for(int val:nums1){
	           set1.add(val);
	       }
	    HashSet<Integer> set2=new HashSet<Integer>();
	       for(int val:nums1){
	           if(set1.contains(val))
	        	   set2.add(val);
	       }
	   
	   int[] result=new int[set2.size()];int i=0;
	       for(int x:set2)
	       {
	           result[i++]=x;
	       }
	       System.out.println("intersection of two arrays::"+set2);
	       return set2;
	}

	private static void bullsAndCows() {
		String secret="1807";
		String hint="7810";
		int bull=0,cow=0;
		for(int i=0;i<secret.length();i++)
		{
			if(secret.charAt(i)==hint.charAt(i))
			{
				bull++;
			}
			else
				cow++;
		}
		System.out.println(bull+"A"+cow+"B");
	}

	private static void eqlibriumIndexOfArray() {
		int arr[]={-7,1,5,2,-4,3,0};
		int sum=0;int leftSum=0;
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
		}
		for(int i=0;i<arr.length;i++)
		{
			sum-=arr[i];	// this is right sum
			if(sum==leftSum)
			{
				System.out.println(arr[i]);
			}
			leftSum+=arr[i];
		}
	}
	

	//similar to union of two arrays
	private static void mergeTwosortedLists() {
	
		int[] arr1 = {1, 3, 4, 5, 7};
		int[] arr2= {2, 3, 5, 6};
		int i=0,j=0,k=0;
		int[] mergedList=new int[arr1.length+arr2.length];
		while(i<arr1.length&&j<arr2.length)
		{
			if(arr1[i]<arr2[j])
			{
			mergedList[k++]=arr1[i];
			i++;
			}
			else if(arr1[i]>arr2[j])
			{
				mergedList[k++]=arr2[j];
				j++;
			}
			else if(arr1[i]==arr2[j])
			{
				mergedList[k++]=arr1[i];
				mergedList[k++]=arr2[j];
				i++;j++;
			}
		}
		while(i<arr1.length)
		{
			mergedList[k++]=arr1[i];
			i++;
		}
		while(j<arr2.length)
		{
			mergedList[k++]=arr2[j];
			j++;
		}
		for(int val:mergedList)
		System.out.print(val);
	}
	
	private static void addRemainingElement(int i,int j,int[] arr1,int[] arr2)
	{
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
		addRemainingElement(i,j,arr1,arr2);
		// not needed for intersection
		
	}
	
	//log n
	private static void reverseArray()
	{
		int[] myArray ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
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
		}
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
		    System.out.println("both maps are Eql");
		}
		else
		{
		    System.out.println("maps are Not euqal");
		}
	}
}

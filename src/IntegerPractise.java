import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class IntegerPractise {

	public static void main(String[] args) {
		fibonacciSeries(10);
		swapWithoutTemp();
		reverseInteger();
		pascalsTriangle(); // o(n^2)
		Computepower(2,6); // o(nlogn)
		findMissingNumber();
		pushZeroesToEnd();
		findSecondLargetsNumber();
		rotateArray();
		removeDuplicatesWithoutDS();
		duplicatesAtmostTwice();
		isPrime();
		countIfDifferenceisNumber();
		findKthLargest();
		addAllDigitsOfANumber();
		twoSum();
		threeSum();
		longestConsecutiveSequence();
		NumberThatOccursOnce();
		FindKClosestElements();
		majorityElement();
		isPowerOfTwo();
		productOfArrayExceptSelf();
		//medianOfTwoSortedArrays();
	}

	private static int[] productOfArrayExceptSelf() {
		int[] nums={1,2,3,4};
		int[] t1=new int[nums.length];
        int[] t2=new int[nums.length];
        int[] result=new int[nums.length];
        t1[0]=1;t2[nums.length-1]=1;
        for(int i=0;i<nums.length-1;i++)
        {
            t1[i+1]=nums[i]*t1[i];
        }
         for(int i=nums.length-1;i>0;i--)
        {
            t2[i-1]=nums[i]*t2[i];
        }
        for(int i=0;i<nums.length;i++)
        {
            result[i]=t1[i]*t2[i];
        }
        return result;
	}

	private static void isPowerOfTwo() {
		int n=64;
		System.out.println(n>0 && (n&n-1)==0);
	}

	//time complexity O(n) space O(1) majority vote linear time algo
	private static void majorityElement() {
		int[] nums={6,5,5};
		int count=0;int result=0;
        for(int i=0;i<nums.length;i++)
        {
            if(count==0){
                result=nums[i];
                count=1;
            }
            else if(result==nums[i])
                count++;
            else
                count--;       
        }
        System.out.println("Majority element "+result);
	}

	// o(n^2)
	private static List<List<Integer>> threeSum() {
		int[] nums={-1, 0, 1, 2, -1, -4};
		List<List<Integer>> ret=new ArrayList<>();
	       if(nums==null || nums.length<3)
	            return ret;
	        Arrays.sort(nums);
	        HashSet<List<Integer>> set = new HashSet<>();
	        for(int i=0;i<nums.length-2;i++)
	        {
	            int start=i+1;
	            int end=nums.length-1;
	            while(start<end)
	            {
	                if(nums[i]+nums[start]+nums[end]==0)
	                {
	                    List<Integer> list=new ArrayList<>();
	                    list.add(nums[i]);
	                    list.add(nums[start]);
	                    list.add(nums[end]);
	                    set.add(list);
	                    start++;
	                    end--;
	                    while(nums[start]==nums[start-1] && start<end)
	                        start++;
	                    while(nums[end]==nums[end+1]&& start<end)
	                        end--;
	                }
	                else if(nums[i]+nums[start]+nums[end]<0)
	                    start++;
	                else
	                    end--;
	            }
	        }
	        ret.addAll(set);
	        System.out.println("Three sum is::"+ret);
	        return ret;
	}

	private static void NumberThatOccursOnce() {
		int[] arr={3,4,5,3,4};
		int result=0;
		for(int i:arr)
		{
			result=result^i;
		}
		System.out.println("Integer that occurs once:"+result);
	}

	private static void FindKClosestElements() {
		int[] arr={12, 16, 22, 30, 35, 39, 42,45, 48, 50, 53, 55, 56};
		int k=4,x=35;int start=0,end=arr.length-1;int crossOver=0;
		while(start<=end)
		{
			int mid=(start+end)/2;
			if(arr[mid]<=x && arr[mid+1]>x)
			{
				crossOver=mid;
			}
			if(arr[mid]>x)
			{
				end=mid-1;
			}
			else
				start=mid+1;
		}
		System.out.println("croosover index"+crossOver);
		
		// to get k closest elements
		int left=crossOver-1;
		int right=crossOver+1;
		List<Integer> val=new ArrayList<Integer>();
		while(left>-1 && right<arr.length && k>0)
		{
			if(arr[crossOver]-arr[left]<arr[right]-arr[crossOver])
			{
				val.add(arr[left]);
				left--;
			}
			else
			{
				val.add(arr[right]);
				right++;
			}
			k--;
		}
		System.out.println("val is"+val);
	}

	// time complexity is o(n) coz we are not sorting
	private static void longestConsecutiveSequence() {
		int[] arr={100, 4, 200, 1, 3, 2};
		Set<Integer> set=new HashSet<>();
		int count=0,max=0;
		for(int i:arr)
		{
			set.add(i);
		}
		for(int i:arr)
		{
			int left=i-1;
			int right=i+1;
			while(set.contains(left))
			{
				set.remove(left);
				left--;
				count++;
			}
			while(set.contains(right))
			{
				set.remove(right);
				right++;
				count++;
			}
			max=Math.max(count,max);
		}
		System.out.println("Maximum elements::"+max);
	}

	//time comlexity o(n)
	// find two numbers that add up to target number
	private static void twoSum() {
		int arr[]={1,2, 7, 8,11, 15};int target=9;
		HashMap<Integer,Integer> hm=new HashMap<>();
		HashMap<Integer, Integer> resultMap=new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
			if(hm.containsKey(arr[i]))
			{
			int index=hm.get(arr[i]);
			resultMap.put(index, i);
			}
			else
			{
				hm.put(target-arr[i], i);
			}
		}
		System.out.println("combinations are::");
		for(Map.Entry<Integer, Integer> val:resultMap.entrySet())
		{
			System.out.println(val.getKey() +" and "+val.getValue());
		}
	}

	private static void addAllDigitsOfANumber() {
		int number=7456;
		int sum=0;
		int last=0;
		while(number>0)
		{
			last=number%10;
			sum=sum+last;
			number=number/10;	
		}
		System.out.println("sum of all digits of a number::"+sum);
	}

	// time complexity O(nlog(k))
	// space complexity O(k)
	private static void findKthLargest() {
		int[] inputArr={3,2,1,5,6,4,7,10};
		int k=3;
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int val: inputArr)
		{
			pq.offer(val);
			if(pq.size()>k){
	            pq.poll();
	        }
		}
		System.out.println("kth largest:"+pq.peek()); 
	}

	private static void duplicatesAtmostTwice() {
		int arr[]={1,1,1,2,2,3};int j =1;
		int prev=0;int counter=1;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[prev]==arr[i])
			{
				counter+=1;
				if(counter<3)
				{
					arr[j++]=arr[i];
				}
				else
					counter=1;
			}
			else
			{
				arr[j++]=arr[i];
			}
			prev=i;
		}
		arr=Arrays.copyOf(arr, j);
		System.out.println("Duplicates atmost twice:"+Arrays.toString(arr));
	}

	//get count of pairs if difference is a given number
	// time complexity o(nlogn)
	// without sorting time complexity is n^2
	private static void countIfDifferenceisNumber() {
		int diffNum=4;
		int arr[]={8, 12, 16, 4, 0, 20};
		int i=0,j=1;int count=0;
		Arrays.sort(arr);
		while(i<arr.length&&j<arr.length)
		{
			// if find only one pair donot increment both iand j
			if(arr[j]-arr[i]==diffNum)
			{
				count++;
				i++;j++;
			}
			else if(arr[j]-arr[i]<diffNum)
				j++;
			else
				i++;
		}
		System.out.println("if Difference is Number total pair found::"+count);
		
		//other approach
		 List<Integer> list=new ArrayList<>();
	        for(int k=0;k<arr.length;k++)
	            {
	            list.add(arr[k]);
	        }
	        count=0;
	        for(int l=0;l<arr.length;l++)
	            {
	            if(list.contains(arr[l]+diffNum))
	                count+=1;
	        }
	        System.out.println("other method for if difference is a number"+count);
		
	}

	//sieve of eratosthenes
	private static int isPrime() {
		int n=50;
		if(n<=2)
            return 0;
		boolean[] primes=new boolean[n]; 
		Arrays.fill(primes, true);
		primes[0]=primes[1]=false;
		for(int i=2;i<primes.length;i++)
		{
			if(primes[i])
			{
				for(int j=2;j*i<primes.length;j++)
				{
					primes[j*i]=false;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < primes.length; i++) {
			if (primes[i])
				count++;
		}
		return count;
	}

	private static void removeDuplicatesWithoutDS() {
		int[] A = {1,1,1,2,2,3};
		int prev=0;int count=1;
		for(int i=1;i<A.length;i++)
		{
			if(A[prev]!=A[i])
				A[count++]=A[i];
			prev=i;
		}
		A=Arrays.copyOf(A, count);
		System.out.println("Removed duplicaties without DS:"+Arrays.toString(A));
	}

	private static void medianOfTwoSortedArrays() {
		int arr1[] = {1, 12, 15, 26, 38};
		int arr2[] = {2, 13, 17, 30, 45};
		int m1=arr1[(arr1[0]+arr1[arr1.length])/2];
		int m2=arr2[(arr2[0]+arr2[arr2.length])/2];
		int m1Arr[];
		if(m1==m2)
		{
			System.out.println(m1);
		}
		else{
		
		
		}
	}

	private static void getMedian(int[] arr) {
		int start=0,end=arr.length-1;
		
	}

	//o(n) and o(1) space
	private static void rotateArray() {
		int[] arr={1,2,3,4,5,6}; int order=2;
		
		if (arr == null || arr.length==0 || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
		
		if(order>arr.length)
			order=order%arr.length;
		
		int a = arr.length - order; 
		reverse(arr,0,a-1);
		reverse(arr,a,arr.length-1);
		reverse(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void reverse(int[] arr, int start, int end) {
		if(arr == null || arr.length == 1) 
			return;
		while(start<end)
		{
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;end--;
		}
	}

	//o(n)
	private static void findSecondLargetsNumber() {
		int[] arr={3,2};
		int max=arr[0],secondMax=0;
		for(int i=1;i<arr.length;i++)
		{
			if(max<arr[i])
			{
				secondMax=max;
				max=arr[i];

			}
			else if(arr[i]>secondMax) 
				{
				secondMax=arr[i];
				}
		}
		System.out.println("Second Maximum number is:"+secondMax);
	}

	//time complexity O(n) space O(1)
	private static void pushZeroesToEnd() {
		// TODO Auto-generated method stub
		int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int n = arr.length;
        int count = 0;
        for(int i=0;i<n;i++)
        {
        	if(arr[i]!=0)
        		arr[count++]=arr[i];
        }
        while (count < n)
            arr[count++] = 0;
        System.out.println("After pushing zeroes to end:");
        for(int val:arr)
        	System.out.print(val);
        System.out.println();
	}

	private static void Computepower(double x, int n) {
		if(x<0){
			System.out.println(1/pow(x,-n));
		}
		else
		{
			System.out.println(pow(x,n));
		}
	}
	
	//log n
	private static double pow(double x,int n)
	{
		if(n==0)
		{
			return 1;
		}
		double v= pow(x,n/2);
		if(n%2==0)
		{
			return v*v;
		}
		else
			return v*v*x;
	}
	
	//need to redo
	private static void pascalsTriangle() {
		int rows=5;
		 for(int i =0;i<rows;i++) {
	            int number = 1;
	           //System.out.format("%"+(rows-i)*2+"s","");
	            for(int j=0;j<=i;j++) {
	                 System.out.format("%4d",number);
	                 number = number * (i - j) / (j + 1);
	            }
	            System.out.println();
	        }
	}

	private static int fibonacciRecusion(int num) {
		if(num==1||num==2)
		{
			return 1;
		}
		return fibonacciRecusion(num-1)+fibonacciRecusion(num-2);	
	}
	
	//dynamic prg - time and space -o(n)
		// recursion - exponential
		private static void fibonacciSeries(int count) {
			int[] feb = new int[count];
	        feb[0] = 0;
	        feb[1] = 1;
	        for(int i=2; i < count; i++){
	            feb[i] = feb[i-1] + feb[i-2];
	        }

	        System.out.println("Fibonacci Using dynamic programming");
	        for(int i=0; i< count; i++){
	                System.out.print(feb[i] + " ");
	        }
	        
	        //using recursion
	        for(int j=2; j < count; j++){
	            feb[j] = fibonacciRecusion(j);
	        }
	        System.out.println("\n Fibonacci Using recusion");
	        for(int i=0; i< count; i++){
	            System.out.print(feb[i] + " ");
	        }  
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
		
		// finds only one missing number
		// if more than one missing number check for i+1 and i difference is greater than 1
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
	
}


public class BinarySearch {

	public static void main(String[] args) {

		//divide and conquer
		int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
        System.out.println("Key 14's position: "+binarySearch(arr, 14));
        int[] arr1 = {6,34,78,123,432,900};
        System.out.println("Key 432's position: "+binarySearch(arr1, 432));
        
        //recursive binary
        int[] arr2 = {2,45,234,567,876,900,976,999};
        int index = recBinarySearch(arr2,0,arr2.length,45);
        System.out.println("Found 45 at "+index+" index");
        index = recBinarySearch(arr2,0,arr2.length,999);
        System.out.println("Found 999 at "+index+" index");
        index = recBinarySearch(arr2,0,arr2.length,876);
        System.out.println("Found 876 at "+index+" index");
	}

	// divide and conquer technique
	private static int binarySearch(int arr[],int number)
	{
		int start =0;
		int end=arr.length-1;
		while(start<=end)
		{
			int mid=(start+end)/2;
			if(arr[mid]==number)
			{
				return mid;
			}
			if(arr[mid]<number)
			{
				start=mid+1;
			}
			else
			{
				end=mid-1;
			}
		}
		return -1;
	}
	
	//recursiev binary search
	private static int recBinarySearch(int arr[],int start,int end,int number)
	{
		if(start<=end)
		{
			int mid=(start+end)/2;
			if(arr[mid]==number)
			{
				return mid;
			}
			else if(arr[mid]<number)
			{
				return recBinarySearch(arr, mid+1, end, number);
			}
			else
			{
				return recBinarySearch(arr, start,mid-1, number);
			}
		}
		return -1;
	}
}

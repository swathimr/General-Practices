
public class Sort {

	public static void main(String[] args) {
		//insertion sort
		int[] arr1 = {10,34,2,56,7,67,88,42};
		int sortedArray[]=insertionSort(arr1);
		for(int val :sortedArray)
		{
			System.out.println(val);
		}
	}

	// average and worst -o(n^2) , best case - O(n), Space -O(1)
	private static int[] insertionSort(int[] inputArr) {
		int temp;
		for(int i=1;i<inputArr.length;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(inputArr[j-1]>inputArr[j])
				{
					temp=inputArr[j-1];
					inputArr[j-1]=inputArr[j];
					inputArr[j]=temp;
				}
			}
		}
		return inputArr;
	}

}

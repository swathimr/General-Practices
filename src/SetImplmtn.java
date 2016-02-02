
public class SetImplmtn<T> {

	private T arrayElement[];
	private int size;
	
	public SetImplmtn()
	{
		arrayElement=(T[])new Object[10];;
		size=0;
	}
	
	public SetImplmtn(int sizeVal)
	{
		size=0;
		arrayElement=(T[])new Object[sizeVal];
	}
	
	public void add(T element)
	{
		if(!contains(element))
		{
			if(size==arrayElement.length)
			{
				increaseArraySize();
			}
			arrayElement[size]=element;
			size++;
		}
	}
	
	private int size()
	{
		if(arrayElement!=null)
		{
			return arrayElement.length;
		}
		return 0;
	}
	
	private void printSet()
	{
		int i=0;
		if(arrayElement!=null)
		{
			while(arrayElement[i]!=null || i>arrayElement.length)
			{
				System.out.println(arrayElement[i]);
				i++;
			}
		}
	}
	
	private boolean contains(T val)
	{
		if(arrayElement!=null)
		{
			for(int i=0;i<arrayElement.length;i++)
			{
				if(arrayElement[i]==val)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	private void increaseArraySize()
	{
		T temp[]=arrayElement;
		int tempSize=size+5;
		arrayElement=(T[]) new Object[tempSize];
		System.arraycopy(temp, 0, arrayElement, 0, size);
	}
	
	private void clear()
	{
		arrayElement=null;
	}
	
	public static void main(String[] args) {
		int sizeval=0;
		SetImplmtn set= new SetImplmtn(6);
		set.add("Hello");
		set.add(2);
		set.add(3);
		set.add("Set");
		set.add("implmntn is");
		set.add("interesting");
		set.add("Testing incresed array size");
		sizeval=set.size();
		System.out.println("Resized arry::"+sizeval);
		set.printSet();
		boolean exists=set.contains(3);
		System.out.println("Contains:: "+exists);
		exists=set.contains(4);
		System.out.println("Contains:: "+exists);
		set.clear();
		System.out.println("Cleared the Set..");
		set.printSet();
		sizeval=set.size();
		System.out.println("Size of the array is:: "+sizeval);
	}

}

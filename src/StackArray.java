
public class StackArray {
	private int maxsize;
	private int[] stackArr;
	private int top=0;
	
	public StackArray(int size)
	{
		this.maxsize=size;
		this.stackArr=new int[maxsize];
	}
	
	public void push(int i)
	{
		if(top<maxsize)
		{
			stackArr[top++]=i;
			System.out.println("Pushed elementinto stack::"+i);
		}
	}

	public void pop()
	{
		int i =stackArr[top];
		top--;
		System.out.println("Popped from stack::"+i);
		System.out.println("Now  top element after pop operation is::"+stackArr[top]);
	}
	
	public int peek()
	{
		return stackArr[top];
	}
	
	public void getSizeStack()
	{
		System.out.println("size f the stack is::"+top);		
	}
	
	public void getTopElement()
	{
		System.out.println("Top element from the stack is::"+stackArr[top]);
	}
}

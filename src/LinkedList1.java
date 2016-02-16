public class LinkedList1 {

	static Node start;
	static Node end;
	private int length;
	
	public LinkedList1()
	{
		start=null;
		end=null;
		length=0;
	}
	
	public void insertElement(int data)
	{
		Node newNode = new Node(data,null);
		length++;
		if(start==null)
		{
			start=newNode;
			end=newNode;
		}
		else{
			end.setNext(newNode);
			end=newNode;
			
		}
	}
	
	public void printList()
	{
		Node current=start;
		while(current!=null)
		{
			System.out.println(current.getData());
			current=current.getLink();
		}
	}
	
	public void insertAtFirst(int data)
	{
		Node newNode = new Node(data,null);
		length++;
		if(start==null)
		{
			start=newNode;
			end=newNode;
		}
		else
		{
			newNode.setNext(start);
			start=newNode;
		}
	}
	
	public boolean searchElement(int data)
	{
		boolean found=false;
		if(start==null)
		{
			System.out.println("Element not found in the list");
		}
		else
		{
			Node current=start;
			while(current!=null && found==false)
			{
			if(current.getData()==data)
			{
				found=true;
			}
			current=current.getLink();
			}
		}
		return found;
	}
	
	//move fast nd slow first
	// move fast again if it isnot null
	// O(N)
	public int findMiddle()
	{
		Node slowptr= start;
		Node fastptr=start;
		int returnValue=-1;
		while(fastptr.getLink()!=null)
		{
			fastptr=fastptr.getLink();
			slowptr=slowptr.getLink();
			if(fastptr.getLink()!=null)
			{
				fastptr=fastptr.getLink();
			}
			returnValue=slowptr.getData();
		}
		return returnValue;
	}
	
	public void reverseList()
	{
		Node current=null;
		Node next=start;
		Node prev=null;
		while(next!=null)
		{
			current=next;
			next=next.getLink();
			current.setNext(prev);
			prev=current;
			System.out.println(prev.getData());
		}
		start=current;
	}
	
	//key is lenght-n+1
	//time complexity is O(N)
	public void finsNthElementfromLast(int num)
	{
		if(start==null)
		{
			System.out.println("No elements are in the list currently");
		}
		else
		{
			Node temp=start;
			for(int i=1;i<length-num+1;i++)
			{
				temp=temp.getLink();
			}
			System.out.println("The "+num+" element from the last is "+temp.getData());
		}
	}
	
	//detect and remove the cyclic loop
	public int cyclicLoop()
	{
		Node slowPtr,fastPtr;
		slowPtr=fastPtr=start;
		while(fastPtr!=null && fastPtr.getLink()!=null)
		{
			slowPtr=slowPtr.getLink();
			fastPtr=fastPtr.getLink();
			if(fastPtr.getLink()!=null)
			{
				fastPtr.getLink();
			}
			if(fastPtr==slowPtr)
			{
				// has a loop remove
				slowPtr=start;
				while(slowPtr!=fastPtr.getLink())
				{
					slowPtr=slowPtr.getLink();
					fastPtr=fastPtr.getLink();
				}
				fastPtr.setNext(null);
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		LinkedList1 llist=new LinkedList1();
		llist.insertElement(10);
		llist.insertElement(6);
		llist.insertElement(20);
		llist.insertAtFirst(9);
		llist.insertElement(22);
		llist.printList();
		boolean searchVal=llist.searchElement(6);
		System.out.println(searchVal);
		searchVal=llist.searchElement(2);
		System.out.println(searchVal);
		int middleValue=llist.findMiddle();
		System.out.println(middleValue);
		llist.finsNthElementfromLast(3);
		llist.reverseList();
		llist.printList();
	}

}

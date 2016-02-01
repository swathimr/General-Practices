
public class Node {

	public int dataNum;
	public Node linkAddr;
	
	public Node()
	{
		this.dataNum=0;
		this.setNext(null);
	}
	
	public Node(int data,Node link)
	{
		this.dataNum=data;
		this.setNext(link);
	}
	
	public void setData(int data)
	{
		this.dataNum=data;
	}
	
	public int getData()
	{
		return dataNum;
	}
	
	public void setNext(Node link)
	{
		this.linkAddr=link;
	}
	
	public Node getLink()
	{
		return linkAddr;
	}
}

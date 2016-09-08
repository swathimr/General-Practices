
public class QueueArray {
	
	private int Queuefront;
	private int QueueRear;
	private int queueArr[];
	private int queueMaxSize;
	private int length=0;
	
	public QueueArray(int size)
	{
		this.queueMaxSize=size;
		queueArr = new int[size];
		Queuefront=0;QueueRear=0;
	}
	
	public void addQueue(int num)
	{
		if(length<=queueMaxSize)
		{
			if(length==0)
			{
				length++;
				queueArr[Queuefront++]=num;
				System.out.println("Added element to the queue"+num+" in position "+Queuefront);
			}
			else
			{
				queueArr[QueueRear++]=num;
				length++;
				System.out.println("Added element to the queue"+num+" in position "+QueueRear);
			}
		}
	}
	
	public void deQueue()
	{
		if(length==0){
			System.out.println("Cannot remove from an empty queue");
		}
		length--;
		System.out.println("Dequeued firtelement from queue::"+queueArr[Queuefront]);
		Queuefront++;
	}
	
	public void QueueFront()
	{
		System.out.println("First element in queue::"+queueArr[Queuefront]);
	}
	
	public void queueBack()
	{
		System.out.println("Last element entered in to queue is::"+queueArr[QueueRear]);
	}
}

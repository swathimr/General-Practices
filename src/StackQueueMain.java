
public class StackQueueMain {

	public static void main(String[] args) {
		StackArray stack = new StackArray(10);
		stack.push(10);
		stack.push(43);
		stack.getTopElement();
		stack.push(38);
		stack.push(23);
		stack.getTopElement();
		stack.pop();
		stack.getSizeStack();
		
		QueueArray queue = new QueueArray(10);
		queue.addQueue(20);
		queue.addQueue(82);
		queue.addQueue(9);
		queue.addQueue(38);
		queue.queueBack();
		queue.QueueFront();
		queue.deQueue();
		queue.addQueue(50);
		queue.queueBack();
		queue.deQueue();
		queue.QueueFront();
	}

}

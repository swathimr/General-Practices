import java.util.LinkedList;
import java.util.Stack;

public class StackQueue {

	LinkedList<Integer> queue1=new LinkedList<>();
	LinkedList<Integer> queue2=new LinkedList<>();
	
	//implement stack using queues
	
	
	// if queue1 is not empty add to queue2 and add all emements from q1 to q2
	// similar for q2
	public void push(int x)
	{
		if(empty())
		{
			queue1.offer(x);
		}else
		{
			if(queue1.size()>0)
			{
			queue2.offer(x);
			int q1size=queue1.size();
			while(q1size>0)
			{
				queue2.offer(queue1.poll());
				q1size--;
			}
			}
			else if(queue2.size()>0)
			{
				queue1.offer(x);
				int q2size=queue2.size();
				while(q2size>0)
				{
					queue1.offer(queue2.poll());
					q2size--;
				}
			}
		}
	}
	
	public boolean empty()
	{
		return queue1.isEmpty()&&queue2.isEmpty();
	}
	
	// Removes the element on top of the stack.
    public void pop() {
        if(queue1.size()>0){
            queue1.poll();
        }else if(queue2.size()>0){
            queue2.poll();
        }
    }
 
    // Get the top element.
    public int top() {
       if(queue1.size()>0){
            return queue1.peek();
        }else if(queue2.size()>0){
            return queue2.peek();
        }
        return 0;
    }
	
    // implement queue using stack
	// all everything from stack to temp and ad value. then add all values from tem tp stack back
    Stack<Integer> stack=new Stack<Integer>();
    Stack<Integer> temp=new Stack<Integer>();
    
    public void pushQ(int x)
    {
    	if(stack.isEmpty())
    	{
    		stack.push(x);
    	}
    	else
    	{
    		while(!stack.empty())
    		{
    			temp.push(stack.pop());
    		}
    		temp.push(x);
    		while(!temp.isEmpty())
    		{
    			stack.push(temp.pop());
    		}
    	}
    }
    
    
    
    
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	protected BinaryNode rootNode;
	
	public BinaryTree()
	{
		rootNode=null;
	}
	
	public void addNode(int val)
	{
		BinaryNode trvrseNode;
		BinaryNode trailNode = null;
		BinaryNode node = new BinaryNode(val);
		if(rootNode==null)
		{
			rootNode = node;
		}
		else
		{
			trvrseNode = rootNode;
			while(trvrseNode!=null)
			{
				trailNode = trvrseNode;
				if(trvrseNode.val==val)
				{
					System.out.println("cannot insert.Duplicate!!");
				}
				else if(trvrseNode.val>val)
				{
					trvrseNode=trvrseNode.leftChild;
				}
				else
				{
					trvrseNode=trvrseNode.rightChild;
				}
			}
			if(trailNode.val>val)
			{
				trailNode.leftChild=node;
			}
			else
			{
				trailNode.rightChild=node;
			}
		}
	}
	
	
	public BinaryNode findNode(int value)
	{
		BinaryNode current=rootNode;
		while(current.val!=value)
		{
			if(current.val>value)
			{
				current=current.leftChild;
			}
			else
			{
				current = current.rightChild;
			}
			if(current==null)
			{
				return null;
			}
		}
		return current;
	}
	
	// iterative is DFS
	//recursive approach
	public void preOrderTraverse(BinaryNode node)
	{
		if(node!=null)
		{
			System.out.println(node.val);
			if(node.leftChild!=null){
				preOrderTraverse(node.leftChild);
				}
			if(node.rightChild!=null){
			preOrderTraverse(node.rightChild);
			}
		}
	}
	
	public void postOrder(BinaryNode node)
	{
		if(node!=null)
		{
			if(node.leftChild!=null){
			postOrder(node.leftChild);
			}
			if(node.rightChild!=null){
			postOrder(node.rightChild);
			}
			System.out.println(node.val);
		}
		
		// postorder iterative approach 
		//peek - if left and rchild is null print val
		// if right is not null push val in to stack nad null the rchild similar for left
		if(node==null)
			return;
		Stack<BinaryNode> stack= new Stack<BinaryNode>();
		stack.push(node);
		while(!stack.isEmpty())
		{
			BinaryNode temp=stack.peek();
			if(temp.leftChild==null&temp.rightChild==null)
			{
				System.out.println(stack.pop().val);
				
			}
			else
			{
				if(temp.rightChild!=null)
				{
					stack.push(temp.rightChild);
					temp.rightChild=null;
				}
				if(temp.leftChild!=null)
				{
					stack.push(temp.leftChild);
					temp.leftChild=null;
				}
			}
		}				
	}
	
	public void inOrderTraverse(BinaryNode node)
	{
		if(node!=null)
		{
			inOrderTraverse(node.leftChild);
			System.out.println(node.val);
			inOrderTraverse(node.rightChild);
		}
		
		// inorder traversal iterative approach
		if(node==null)
			return;
		Stack<BinaryNode> stack=new Stack<BinaryNode>();
		stack.push(node);
		while(!stack.isEmpty())
		{
			BinaryNode temp=stack.peek();
			if(temp.leftChild!=null)
			{
				stack.push(temp.leftChild);
				temp.leftChild=null;
			}
			else
			{
				System.out.println(temp.val);
				stack.pop();
				if(temp.rightChild!=null)
					stack.push(temp.rightChild);
				
			}
		}
		
	}
	
	//time complexity o(n)
	public BinaryNode sortedArrayToBST(int[] arr, int start, int end)
	{
		if(start>end)
			return null;
		int mid=(start+end)/2;
		BinaryNode root=new BinaryNode(arr[mid]);
		root.leftChild=sortedArrayToBST(arr, start, mid-1);
		root.rightChild=sortedArrayToBST(arr, mid+1, end);
		return root;
	}
	
	public int heightOfBinaryTree(BinaryNode node)
	{
		if(node==null)
		{
			return -1;
		}
		else
		{
			return 1+Math.max(heightOfBinaryTree(node.leftChild),heightOfBinaryTree(node.rightChild));
		}
	}
	
	public int minimumDepthOfBinaryTree(BinaryNode root)
	{
		if(root ==null)
            return 0;
        LinkedList<BinaryNode> node=new LinkedList<>();
        LinkedList<Integer> counts=new LinkedList<>();
        node.add(root);
        counts.add(1);
        while(!node.isEmpty()){
        	BinaryNode temp=node.remove();
            int count=counts.remove();
            if(temp.leftChild==null && temp.rightChild==null)
                return count;
            if(temp.leftChild!=null)
            {
                node.add(temp.leftChild);
                counts.add(count+1);
            }
            if(temp.rightChild!=null)
            {
                node.add(temp.rightChild);
                counts.add(count+1);
            }
        }
        return 0;
	}
	
	//O(log n)
	public BinaryNode lowestCommonAncestor(BinaryNode node, int value1,int value2 )
	{
		if(node.val<value1 && node.val<value2)
		{
			return lowestCommonAncestor(node.rightChild, value1, value2);
		}
		if(node.val>value1 && node.val>value2)
		{
			return lowestCommonAncestor(node.leftChild, value1, value2);
		}
		return  node;
	}
	
	//k distance from root O(n)
	public void printKNode(BinaryNode node, int k)
	{
		if(node==null){
			return;
		}
		if(k==0)
		{
			System.out.println(node.val);
			return;
		}
		printKNode(node.leftChild, k-1);
		printKNode(node.rightChild, k-1);
	}
	
	//levelorder
	public void BFS(BinaryNode node)
	{
		Queue<BinaryNode> queue = new LinkedList<>();
		if(node==null)
		{
			return;
		}
		queue.add(node);
		while(!queue.isEmpty())
		{
			BinaryNode nodeVal = queue.remove();
			System.out.println(nodeVal.val);
			if(nodeVal.leftChild!=null)
			{
				queue.add(nodeVal.leftChild);
			}
			if(nodeVal.rightChild!=null)
			{
				queue.add(nodeVal.rightChild);
			}
		}
	}
	
	//preorder iterative
	// non recursive
	public void DFS(BinaryNode node)
	{
		Stack stack =new Stack<>();
		if(node==null)
		{
			return;
		}
		stack.push(node);
		while(!stack.isEmpty())
		{
			BinaryNode nodeval = (BinaryNode) stack.pop();
			System.out.println(nodeval.val);
			if(nodeval.rightChild!=null)
			{
				stack.push(nodeval.rightChild);
			}
			if(nodeval.leftChild!=null)
			{
				stack.push(nodeval.leftChild);
			}
		}
	}
	
	public boolean isLeaf(BinaryNode node)
	{
		if(node==null)
		{
			return false;
		}
		if(node.leftChild==null && node.rightChild==null)
		{
			return true;
		}
		return false;
	}
	
	
	//time complexity O(n)
	//space o(1)
	public int sumOfLeftLeaves(BinaryNode node,int result)
	{
		if(node==null)
		{
			return 0;
		}
			if(isLeaf(node.leftChild))
			{
				result+=node.leftChild.val;
			}
			sumOfLeftLeaves(node.leftChild, result);
			sumOfLeftLeaves(node.rightChild, result);
			return result;
	}
	
	
	// recursion, post order traversal technique
	// if difference between them is greater return -1 else 1+math.max
	// store height of each level and add 1 to it wen going up. hence time complexity o(n)
	public int isBalanced(BinaryNode node)
	{
		if(node==null)
			return 0;
		int lefth=isBalanced(node.leftChild);
		int righth=isBalanced(node.rightChild);
		if(righth==-1 || lefth==-1)
			return -1;
		if(Math.abs(lefth-righth)>1)
			return -1;
		return 1+Math.max(lefth,righth);
	}
	
	public void checkBalance(BinaryNode root)
	{
		if(root==null)
			return;
		int result=isBalanced(root);
		if(result>0)
			System.out.println("yes it is balanced");
		else
			System.out.println("false");
	}
	
	/* method to check if path adds up to the sum
	* returns boolean
	* time complexity - O(n)
	*/ 
	public boolean hasPathSum(BinaryNode node, int sum) { 
	
	if(node==null)
		return false;
	int subSum = sum-node.val;
	if(node.leftChild==null && node.rightChild==null)
		return (subSum==0);
	else{
	  // otherwise check both subtrees
	  if ( node.leftChild != null && hasPathSum(node.leftChild, subSum))
		  return true;
	  if ( node.rightChild != null && hasPathSum(node.rightChild, subSum))
	        return true;
	  return false;
		}
	}
	
	//gets maximum sum of all the paths recursive
	public int maxPathSum(BinaryNode root) {
		int max[] = new int[1]; 
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}
	
	public int calculateSum(BinaryNode root,int[] max)
	{
		if(root==null)
			return 0;
		int left=calculateSum(root.leftChild, max);
		int right=calculateSum(root.rightChild, max);
		int current=Math.max(root.val+left,root.val+right);
		max[0]=Math.max(max[0],Math.max(current, root.val+left+right));
		return current;
	}
	
	public BinaryNode invertTree(BinaryNode root)
	{
		Queue<BinaryNode> queue=new LinkedList();
		if(root!=null)
		{
			queue.add(root);
		}
		while(!queue.isEmpty())
		{
			BinaryNode q=queue.poll();
			if(q.leftChild!=null)
			{
				queue.add(q.leftChild);
			}
			if(q.rightChild!=null)
			{
				queue.add(q.rightChild);
			}
			BinaryNode temp=q.leftChild;
			temp.leftChild=q.rightChild;
			temp.rightChild=temp;
		}
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addNode(50);
		tree.addNode(25);
		tree.addNode(15);
		tree.addNode(30);
		tree.addNode(75);
		tree.addNode(85);
		System.out.println("preorder:::::::");
		tree.preOrderTraverse(tree.rootNode);
		System.out.println("post order:::::::");
		tree.postOrder(tree.rootNode);
		System.out.println("inorder::::");
		tree.inOrderTraverse(tree.rootNode);
		System.out.println("tree with node 75"+tree.findNode(75));
		int height=tree.heightOfBinaryTree(tree.rootNode);
		System.out.println("Height of the binary tree is::"+height);
		BinaryNode LCA=tree.lowestCommonAncestor(tree.rootNode, 15, 30);
		System.out.println("Lowest Common Ancestor::"+LCA.val);
		tree.printKNode(tree.rootNode, 1);
		tree.sumOfLeftLeaves(tree.rootNode,0);
	}

}

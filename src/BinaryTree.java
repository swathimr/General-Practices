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
	}
	
	public void inOrderTraverse(BinaryNode node)
	{
		if(node!=null)
		{
			inOrderTraverse(node.leftChild);
			System.out.println(node.val);
			inOrderTraverse(node.rightChild);
		}
	}
	
	public int heightOfBinaryTree(BinaryNode node)
	{
		if(node==null)
		{
			return 0;
		}
		else
		{
			return 1+Math.max(heightOfBinaryTree(node.leftChild),heightOfBinaryTree(node.rightChild));
		}
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
	
	//k distance from root
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
			if(nodeval.leftChild!=null)
			{
				stack.push(nodeval.leftChild);
			}
			if(nodeval.rightChild!=null)
			{
				stack.push(nodeval.rightChild);
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

package binarytree;

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
			preOrderTraverse(node.leftChild);
			preOrderTraverse(node.rightChild);
		}
	}
	
	public void postOrder(BinaryNode node)
	{
		if(node!=null)
		{
			postOrder(node.leftChild);
			postOrder(node.rightChild);
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
		while(node!=null)
		{
			if(node.val>value1 && node.val>value2)
			{
				node=node.leftChild;
			}
			else if(node.val<value1 && node.val<value2)
			{
				node=node.rightChild;
			}
			else
			{
				return node;
			}
		}
		return null;
	}
	
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
	}

}

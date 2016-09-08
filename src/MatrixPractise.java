import java.util.ArrayList;
import java.util.List;

public class MatrixPractise {

	public static void main(String[] args) {
		//rotateImage();
		//setZeroes();
	}

	//n^2
	private static void setZeroes(int[][] matrix) {
		boolean[] rows=new boolean[matrix.length];
		boolean column[]=new boolean[matrix[0].length];
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				if(matrix[i][j]==0)
				{
					rows[i]=true;
					column[j]=true;
				}
			}
		}
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				if(rows[i]||column[j]){
				matrix[i][j]=1;	
				}
			}
		}
			
	}

	//o(n^2)
	private static void rotateImage(int[][] matrix) {
		int n=matrix.length;
        for(int i=0;i<n/2;i++)
        {
            for(int j=0;j<Math.ceil((double)n/2.);j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }
        }	
	}
	
	//o(m*n)
	private static List spiralMatrix(int[][] matrix)
	{
		List<Integer> list=new ArrayList<>();
        if(matrix.length==0 || matrix==null)
            return list;
        int top=0;int left=0;
        int right=matrix[0].length-1;
        int down=matrix.length-1;
        while(true)
        {
            for(int j=left;j<=right;++j)
            {
                list.add(matrix[top][j]);
            }
            top++;
            if(top>down || left>right)
                break;
            for(int i=top;i<=down;++i)
            {
                list.add(matrix[i][right]);
            }  
            right--;
           if(top>down || left>right)
                break;
            for(int j=right;j>=left;--j)
            {
                list.add(matrix[down][j]);
            }
            down--;
           if(top>down || left>right)
                break;
            for(int i=down;i>=top;--i)
            {
                list.add(matrix[i][left]);
            }
            left++;
           if(top>down || left>right)
                break;
        }
     return list;       
	}

}

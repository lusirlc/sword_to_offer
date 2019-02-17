package algorithm;

/**
 * 题目:二维数组中的的查找
 * 内容:在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * <p>
 * Created By Chuan Lu On 2019/2/16 21:04
 */
public class FindNumINTwoDimensionalArray {
	
	
	/**
	 * 1.审题:二维数组,每行从左至右递增,每列从上至下递增
	 * [
	 * [1,4,7],
	 * [2,5,8],
	 * [3,6,9],
	 * ]
	 * 2.方法:
	 * 2.1 第一行开始从左至右进行依次进行对比,但这样就忽略了题意,要发现规律,
	 * 打比方我要找5在不在矩阵中,如果是依次进行对比,需要对比5次,如果是按照规律来,
	 * 从右上角7开始,数字比7大往下,比7小往左,那么依次对比的顺序是7,4,5,对比三次即可找到答案
	 */
	
	public boolean findNum(int target, int[][] matrix) {// matrix:矩阵
		//1.对参数进行非空验证
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		//2.设置矩阵最右上角的数字为temp,矩阵内的数组长度为cols,矩阵长度为rows
		int cols = matrix[0].length;
		int rows = matrix.length;
		int startCol = cols - 1;
		int startRow = 0;
		boolean flag = false;
		int temp = matrix[startRow][startCol];
		while (startCol >= 0 && startRow < rows) {
			temp = matrix[startRow][startCol];
			if (target == temp) {
				flag = true;
				break;
			} else if (target < temp) {
				startCol--;
			} else if (target > temp) {
				startRow++;
			}
			
		}
		return flag;
	}
	
	int method() {
		return 1;
	}
	
	public static void main(String[] args) {
		int target = -2;
		int[][] matrix = {
				{1, 4, 7},
				{2, 5, 8},
				{3, 6, 9}
		};
		FindNumINTwoDimensionalArray claz = new FindNumINTwoDimensionalArray();
		boolean result = claz.findNum(target, matrix);
		System.out.println(result);
//		System.out.println(claz.method());
	}
}


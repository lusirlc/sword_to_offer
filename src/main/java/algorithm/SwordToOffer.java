package algorithm;

/**
 * 剑指offer算法题
 * Created By Chuan Lu On 2019/2/17 14:51
 */
public class SwordToOffer {
	
	/**
	 * 题目1:二维数组中的的查找
	 * 内容:在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
	 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
	 *
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
	
	/**
	 *
	 * 题目2:替换空格
	 * 内容:请实现一个函数，将一个字符串中的每个空格替换成“%20”。
	 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
	 *
	 * 解题思路
	 *
	 * 在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），
	 * 因此当遍历到一个空格时，需要在尾部填充两个任意字符。
	 * 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。
	 * P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），
	 * 否则就填充上 P1 指向字符的值。
	 * 从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容
	 * @param str
	 * @return
	 */
	public static String replaceSpace1(StringBuffer str) {
		// p1指针指向原字符串最后一位
		int p1 = str.length() - 1;
		for (int i = 0; i <= p1; i++) {
			if (str.charAt(i) == ' ') {
				// 扩充字符数组长度,一位字符替换为三位字符,扩充2位长度
				str.append("  ");
			}
		}
		// p2指针指向新字符串最后一位
		int p2 = str.length() - 1;
		// 开始替换
		while (p1 >= 0 && p2 > p1) {
			char c = str.charAt(p1--);
			if (c == ' ') {
				str.setCharAt(p2--, '0');
				str.setCharAt(p2--, '2');
				str.setCharAt(p2--, '%');
			} else {
				str.setCharAt(p2--, c);
			}
		}
		return str.toString();
	}
}

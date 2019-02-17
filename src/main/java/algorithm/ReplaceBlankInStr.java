package algorithm;

/**
 * 题目:替换空格
 * 内容:请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * Created By Chuan Lu On 2019/2/16 23:39
 */
public class ReplaceBlankInStr {
	// 自己想的方法
	public static String replaceBlank(String str) {
		String newStr = str.replace(" ", "%20");
		return newStr;
	}
	
	// 底层方法
	
	/**
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
	
	
	
	public static void main(String[] args) {
//		System.out.println(ReplaceBlankInStr.replaceBlank("We Are Happy"));
		System.out.println(ReplaceBlankInStr.replaceSpace1(new StringBuffer("hello ")));
	}
}

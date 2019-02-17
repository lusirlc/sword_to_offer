package algorithm;

import org.junit.Test;

/**
 * Created By Chuan Lu On 2019/2/17 14:57
 */

public class SwordToOfferTest {
	
	@Test
	public void findNum() {
		int target = -2;
		int[][] matrix = {
				{1, 4, 7},
				{2, 5, 8},
				{3, 6, 9}
		};
		System.out.println(SwordToOffer.findNum(target, matrix));
	}
	
	@Test
	public void replaceSpace() {
		System.out.println(SwordToOffer.replaceSpace(new StringBuffer("hello ")));
	}
}

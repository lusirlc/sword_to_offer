package algorithm;

import model.ListNode;
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
	
	@Test
	public void printListFromTailToHead1() {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		System.out.println(SwordToOffer.printListFromTailToHead1(listNode));
	}
	
	@Test
	public void printListFromTailToHead2() {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		System.out.println(SwordToOffer.printListFromTailToHead2(listNode));
	}
	
	@Test
	public void printListFromTailToHead3() {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		System.out.println(SwordToOffer.printListFromTailToHead3(listNode));
	}
}

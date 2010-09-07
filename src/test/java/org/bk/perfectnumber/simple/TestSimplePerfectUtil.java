package org.bk.perfectnumber.simple;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSimplePerfectUtil {
	
	SimplePerfectNumberUtil pUtil = new SimplePerfectNumberUtil();
	

	
	@Test
	public void testPerfectNumberSimple(){
		assertEquals(1, countPerfectNumbersInRange(33550300, 33550400));
	}
	
	private int countPerfectNumbersInRange(int start, int end){
		
		int count = 0;
		long startTime = System.nanoTime();

		for (int i=start; i<=end; i++ ){
//			System.out.println(i);
			if (pUtil.isPerfect(i)) {
				System.out.println(i + " is perfect ");
				count++;
			}
		}
		long endTime = System.nanoTime();
		System.out.println("****** - Java - Single Thread : " + (endTime - startTime) / 1000000000.0);
		return count;
	}
}

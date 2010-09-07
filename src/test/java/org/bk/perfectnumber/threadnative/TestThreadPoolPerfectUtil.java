package org.bk.perfectnumber.threadnative;

import static org.junit.Assert.*;

import org.bk.perfectnumber.PerfectNumberUtil;
import org.bk.perfectnumber.threadnative.ThreadPoolPerfectNumberUtil;
import org.junit.Test;


public class TestThreadPoolPerfectUtil {
	
	PerfectNumberUtil pUtil = new ThreadPoolPerfectNumberUtil();
	

	
	@Test
	public void testPerfectNumberExecutors(){
		assertEquals(1, countPerfectNumbersInRange(33550300, 33550400));
	}
	
	private int countPerfectNumbersInRange(int start, int end){
		int count = 0;
		long startTime = System.nanoTime();
		

		for (int i=start; i<=end; i++ ){
//			System.out.println(i);
			if (pUtil.isPerfect(i)) count++;
		}
		long endTime = System.nanoTime();
		System.out.println("****** - Java - With Thread Native : " + (endTime - startTime) / 1000000000.0);
		return count;
	}
}

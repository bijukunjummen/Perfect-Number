package org.bk.perfectnumber.si;

import static org.junit.Assert.*;

import org.bk.perfectnumber.PerfectNumberUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/si.xml")
public class TestSIPerfectUtil {
	
	@Autowired
	PerfectNumberUtil perfectNumberUtil;
	

	
	@Test
	public void testPerfectNumberSimple(){
		assertEquals(1, countPerfectNumbersInRange(33550300, 33550400));
	}
	
	private int countPerfectNumbersInRange(int start, int end){
		
		int count = 0;
		long startTime = System.nanoTime();

		for (int i=start; i<=end; i++ ){
//			System.out.println(i);
			if (perfectNumberUtil.isPerfect(i)) count++;
		}
		long endTime = System.nanoTime();
		System.out.println("****** - Java - Spring Integration : " + (endTime - startTime) / 1000000000.0);
		return count;
	}
}

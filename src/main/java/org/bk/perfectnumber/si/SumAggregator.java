package org.bk.perfectnumber.si;

import java.util.List;

public class SumAggregator {
	public Integer aggregate(List<Integer> indivSums){
		int sum = 0;
		for (Integer aSum:indivSums ){
			sum += aSum;
		}
		
		return sum;
	}

}

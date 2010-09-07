package org.bk.perfectnumber.simple;

import org.bk.perfectnumber.PerfectNumberUtil;

public class SimplePerfectNumberUtil implements PerfectNumberUtil{

	@Override
	public boolean isPerfect(int aNumber) {
		return sumOfFactors(aNumber)==2*aNumber;
    }
	
	private int sumOfFactors(int aNumber){
		int sum = 0;
		for (int i=1;i<=aNumber;i++){
			if (aNumber%i==0){
				sum+=i;
			}
		}
		
		return sum;
	}

}

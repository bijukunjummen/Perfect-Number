package org.bk.perfectnumber.si;

import org.bk.perfectnumber.PerfectNumberUtil;

public class SIPerfectNumberUtil implements PerfectNumberUtil{
	
	private SumOfFactorsGateway sumOfFactorsGateway;

	@Override
    public boolean isPerfect(int aNumber) {
	    int sum = sumOfFactorsGateway.sumFactors(Integer.valueOf(aNumber));
	    if (sum==2*aNumber) return true;
	    return false;
    }

	public void setSumOfFactorsGateway(SumOfFactorsGateway sumOfFactorsGateway) {
    	this.sumOfFactorsGateway = sumOfFactorsGateway;
    }
	
	
	

}

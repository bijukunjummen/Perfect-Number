package org.bk.perfectnumber.threadnative;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.bk.perfectnumber.Constants;
import org.bk.perfectnumber.PerfectNumberUtil;


public class ThreadPoolPerfectNumberUtil implements PerfectNumberUtil{ 
	private ExecutorService threadpool = Executors.newFixedThreadPool(3);
	@SuppressWarnings("unchecked")
    public boolean isPerfect(int aNumber) {
	    int RANGE = Constants.RANGE;
	    int numberOfPartitions = new Double(Math.ceil(aNumber * 1.0 / RANGE)).intValue();
	    Future<Integer>[] sumOfFactors = new Future[numberOfPartitions];
	    
	    for (int i=0;i<numberOfPartitions;i++) {
	    	int lower = i * RANGE + 1;
	    	int upper = (i+1)* RANGE;
	    	if (aNumber<upper) upper = aNumber;
	    	sumOfFactors[i] = threadpool.submit(new SumOfFactorsTask(lower,upper,aNumber));
	    }
	    
	    int sum = 0;
	    for (int i=0;i<numberOfPartitions;i++) {
	    	try {
	            sum += sumOfFactors[i].get();
            } catch (Exception e) {
            	throw new RuntimeException(e);
            }
	    }
	    
	    if (sum==2*aNumber) return true;
	    
	    return false;
	    
	    
	    
    }

}


class SumOfFactorsTask implements Callable<Integer>{

	private final int lower;
	private final int upper;
	private final int anumber;
	
	
	public SumOfFactorsTask(int lower, int upper, int anumber){
		this.lower = lower;
		this.upper = upper;
		this.anumber = anumber;
	}
	
	
	@Override
    public Integer call() {
		int sum=0;
		for (int i=lower;i<=upper;i++){
			if (anumber%i==0){
				sum+=i;
			}
		}		
		
		return sum;
    }

}
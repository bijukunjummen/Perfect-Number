package org.bk.perfectnumber.si;

import java.util.ArrayList;
import java.util.List;

import org.bk.perfectnumber.Constants;


public class RangeSplitter {
	public List<FactorsRange> split(Integer aNumber){
	    int numberOfPartitions = new Double(Math.ceil(aNumber * 1.0 / Constants.RANGE)).intValue();
	    List<FactorsRange> listOfFactors = new ArrayList<FactorsRange>();
	    for (int i=0;i<numberOfPartitions;i++) {
	    	int lower = i * Constants.RANGE + 1;
	    	int upper = (i+1)* Constants.RANGE;
	    	if (aNumber<upper) upper = aNumber;
	    	listOfFactors.add(new FactorsRange(lower, upper, aNumber));
	    }
	    
	    return listOfFactors;
	}
	

}

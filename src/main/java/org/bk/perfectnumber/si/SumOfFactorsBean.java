package org.bk.perfectnumber.si;


public class SumOfFactorsBean {

	public Integer sumFactors(FactorsRange factorsRange) {
//		System.out.println(factorsRange + " " + Thread.currentThread());
		int sum = 0;
		for (int i = factorsRange.getLower(); i <= factorsRange.getUpper(); i++) {
			if (factorsRange.getAnumber() % i == 0) {
				sum += i;
			}
		}
		return sum;
	}

}

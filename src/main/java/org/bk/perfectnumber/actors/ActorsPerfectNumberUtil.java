package org.bk.perfectnumber.actors;

import org.bk.perfectnumber.Constants;
import org.bk.perfectnumber.PerfectNumberUtil;

import kilim.Mailbox;
import kilim.Task;


public class ActorsPerfectNumberUtil extends Task implements PerfectNumberUtil {

	private Mailbox<FactorsRange> mailbox;
	private Mailbox<Integer> resultmailbox;
	private SumOfFactorsActor sumOfFactors;

	public ActorsPerfectNumberUtil() {
		mailbox = new Mailbox<FactorsRange>();
		resultmailbox = new Mailbox<Integer>();
		sumOfFactors = new SumOfFactorsActor(mailbox, resultmailbox);
		sumOfFactors.start();

	}

	public boolean isPerfect(int aNumber) {
		int RANGE = Constants.RANGE;
		int numberOfPartitions = new Double(Math.ceil(aNumber * 1.0 / RANGE)).intValue();

		for (int i = 0; i < numberOfPartitions; i++) {
			int lower = i * RANGE + 1;
			int upper = (i + 1) * RANGE;
			if (aNumber < upper)
				upper = aNumber;
			mailbox.putnb(new FactorsRange(lower, upper, aNumber));
		}

		int sum = 0;
		for (int i = 0; i < numberOfPartitions; i++) {
				sum += resultmailbox.getb();
		}

		if (sum == 2*aNumber)
			return true;

		return false;
	}


}

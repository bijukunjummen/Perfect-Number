package org.bk.perfectnumber.actors;

import kilim.Mailbox;
import kilim.Pausable;
import kilim.Scheduler;
import kilim.Task;

public class SumOfFactorsActor extends Task{
	
	private Mailbox<FactorsRange> mailbox;
	private Mailbox<Integer> resultmailbox;
	
	public SumOfFactorsActor(Mailbox<FactorsRange> mailbox, Mailbox<Integer> resultmailbox){
		this.mailbox = mailbox;
		this.resultmailbox = resultmailbox;
		setScheduler(new Scheduler(2));
	}

	@Override
    public void execute() throws Pausable, Exception {
		while (true) {			
			   FactorsRange factorsRange = mailbox.get(); // blocks
				int sum=0;
				for (int i=factorsRange.getLower();i<=factorsRange.getUpper();i++){
					if (factorsRange.getAnumber()%i==0){
						sum+=i;
					}
				}		
				resultmailbox.putnb(sum);
		}
    }

}

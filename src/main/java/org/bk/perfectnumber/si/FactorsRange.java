package org.bk.perfectnumber.si;

public class FactorsRange{
	private int lower;
	private int upper;
	private int anumber;
	
	public FactorsRange(){
		
	}
	public FactorsRange(int lower, int upper, int anumber){
		this.lower = lower;
		this.upper = upper;
		this.anumber = anumber;
	}

	public int getLower() {
    	return lower;
    }

	public int getUpper() {
    	return upper;
    }

	public int getAnumber() {
    	return anumber;
    }

	@Override
    public String toString() {
	    return "FactorsRange [anumber=" + anumber + ", lower=" + lower + ", upper=" + upper + "]";
    }
}

package com.wipro.eb.entity;

public class Commercial extends Connection {
	public Commercial(int currentReading, int previousReading,float slabs[])
	{
		super(currentReading,previousReading,slabs);
	}
	
	public float computeBill()
	{
		int units=currentReading-previousReading;
		float bill;
		if(units<50)
		{
			bill=units*slabs[0];
		}
		else if(units<100)
		{
			bill=50*slabs[0]+(units-50)*slabs[1];
		}
		else
		{
			bill=50*slabs[0]+50*slabs[1]+(units-100)*slabs[2];
		}
		if(bill>=10000)
		{
			return (float)(bill+bill*0.09);
		}
		else if(bill>=5000)
		{
			return (float)(bill+bill*0.06);
		}
		else
			return (float)(bill+bill*0.02);
	}

}

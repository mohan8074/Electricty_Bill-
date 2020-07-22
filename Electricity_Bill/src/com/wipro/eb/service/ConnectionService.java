package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
		if(currentReading<previousReading||currentReading<0||previousReading<0)
			throw new InvalidConnectionException("Not valid");
		if(!(type.equals("Domestic")||type.equals("Commercial")))
			throw new InvalidReadingException("Not valid");
		else 
			return true;
	}
	
	public float caluculateBillAmount(int currentReading, int previousReading, String type)
	{
		float billAmount=0;
		try {
			if(validate(currentReading,previousReading,type))
			{
				Connection c;
				if(type.compareTo("Domestic")==0)
				{
					float[] slabs= {2.3f,4.2f,5.5f};
					c= new Domestic(currentReading,previousReading,slabs);
					billAmount=c.computeBill();
				}
				else if(type.compareTo("Commercial")==0)
				{
					float[] slabs= {5.2f,6.8f,8.3f};
					c= new Commercial(currentReading,previousReading,slabs);
					billAmount=c.computeBill();
				}
			}
		}
		catch(InvalidConnectionException ec)
		{
			billAmount=-2;
		}
		catch(InvalidReadingException ex)
		{
			billAmount=-1;
		}
		return billAmount;
	}
	
	public String generateBill(int currentReading, int previousReading, String type)
	{
		ConnectionService cs=new ConnectionService();
		float billAmt=cs.caluculateBillAmount(currentReading, previousReading, type);
		if(billAmt==-1)
		{
			return "Incorrect Reading";
		}
		else if(billAmt==-2)
		{
			return "Incorrect Connection";
		}
		else
			return "Amount to be paid:"+billAmt;
	}

}

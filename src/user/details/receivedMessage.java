package user.details;

import java.sql.Timestamp;

public class receivedMessage 
{
	private String name, message;
	Timestamp time;
	
	public receivedMessage(String sender, String text, Timestamp datetime)
	{
		this.name = sender;
		this.message = text;
		this.time = datetime;
	}
	public String getName() 
	{
		return name;
	}

	public String getMessage() 
	{
		return message;
	}

	public  Timestamp getTime() 
	{
		return time;
	}
	
}

package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils
{
	public static String loadFileAsString(String path)
	{
		StringBuilder sb = new StringBuilder();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
			{
				sb.append(line + "\n");
			}
			br.close();
			
		}
		catch(IOException e)
		{
			
		}
		
		return sb.toString();
	}
	
	public static int parseInt(String number)
	{
		try 
		{
			return Integer.parseInt(number);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
}

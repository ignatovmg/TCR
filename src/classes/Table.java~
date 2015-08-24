package classes;

import java.lang.*;
import java.util.*;
import java.io.*;

public class Table
{
	int AlphaNum;
	int BetaNum;
	
	Vector AlphaArray;
	Vector BetaArray;
	
	public void AlphaRead(String fileName) throws IOException
	{
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		String line;
		AlphaArray = new Vector();
		int i = 0;
		int flag = 1;
		int[] array = new int[8];
		
		while((line = file.readLine()) != null)
		{
			String[] list = line.split("/");
			int buf = 0;
			
			if (list.length != 16)
				flag = 0;
			else
				for (int n = 0; n < 12; n++)
				{	
					if ((n+1)%3 != 0)
						array[n-buf] = Integer.parseInt(list[3+n]);
					else
						buf++;
						
					if (array[n-buf] == -1)
						if ((n-buf != 2) && (n-buf != 3) && (n-buf != 6) && (n-buf != 7))
						{
							flag = 0;
							break;
						}
				}
		
			if (flag != 0)
			{
				AlphaArray.addElement(new AlphaChain(list[1], list[2], 
					new int[]{array[0], array[1]},
					list[5],
					new int[]{array[4], array[5]},
					list[11],
					new int[]{array[6], array[7]},
					list[14],
					list[15]));
				i+=1;
			}
			flag = 1;
		}
		AlphaNum = i;
		file.close();
	}
	
	public void BetaRead(String fileName) throws IOException
	{
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		String line;
		BetaArray = new Vector();
		int i = 0;
		int flag = 1;
		int[] array = new int[8];
		while((line = file.readLine()) != null)
		{
			String[] list = line.split("/");
			int buf = 0;
			
			if (list.length != 16)
				flag = 0;
			else
				for (int n = 0; n < 12; n++)
				{	
					if ((n+1)%3 != 0)
						array[n-buf] = Integer.parseInt(list[3+n]);
					else
						buf++;
						
					if (array[n-buf] == -1)
						if ((n-buf != 2) && (n-buf != 3) && (n-buf != 6) && (n-buf != 7))
						{
							flag = 0;
							break;
						}
				}
		
			if (flag != 0)
			{
				BetaArray.addElement(new BetaChain(list[1], list[2], 
					new int[]{array[0], array[1]},
					list[5],
					new int[]{array[2], array[3]},
					list[8],
					new int[]{array[4], array[5]},
					list[11],
					new int[]{array[6], array[7]},
					list[14],
					list[15]));
				i++;
			}
			flag = 1;
		}
		BetaNum = i;
		file.close();
	}
	
	public void AlphaWrite(String fileName) throws IOException
	{
		BufferedWriter file = new BufferedWriter(new FileWriter(fileName));
		int i = 0;
		AlphaChain buf;
		for (i = 0; i < AlphaNum; i++)
		{
			buf = (AlphaChain)AlphaArray.get(i);
			buf.Write(file);
			file.write("\n");
		}
		file.close();
	}
	
	public void BetaWrite(String fileName) throws IOException
	{
		BufferedWriter file = new BufferedWriter(new FileWriter(fileName));
		int i = 0;
		BetaChain buf;
		for (i = 0; i < BetaNum; i++)
		{
			buf = (BetaChain)BetaArray.get(i);
			buf.Write(file);
			file.write("\n");
		}
		file.close();
	}
}
	

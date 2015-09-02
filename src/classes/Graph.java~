package classes;

import java.lang.*;
import java.util.*;
import java.io.*;

public class Graph
{
	int[][] Data;
	int Size;
	
	public void GraphFill(Vector<Chain> Array, int flag)
	{
		if (Array != null)
			if (!Array.isEmpty())
			{
				Size = Array.size();
				Data = new int[Size][Size];
				switch (flag)
				{
					case 0:
						this.GraphFill0(Array);
						break;
					case 1:
						this.GraphFill1(Array);
						break;
				}
			}
			else
			{
				System.out.println("Table is empty!");
				System.exit(0);
			}
		else
		{
				System.out.println("Null pointer received by Graph!");
				System.exit(0);
		}
	}
	
	private void GraphFill0(Vector<Chain> Array)
	{
		for (int i = 0; i < Size; i++)
		{
			for (int j = i; j < Size; j++)
			{
				if (Array.get(i).Antigen.equals(Array.get(j).Antigen))
				{
					Data[i][j] = 1;
					Data[j][i] = 1;
				}
				else
				{
					Data[i][j] = 0;
					Data[j][i] = 0;
				}
			}
		}
	}
	
	private void GraphFill1(Vector<Chain> Array)
	{
		for (int i = 0; i < Size; i++)
		{
			for (int j = i; j < Size; j++)
			{
				String CDR3_i = Array.get(i).CDR3;
				String CDR3_j = Array.get(j).CDR3;
				double dist = (double)Utilities.EditorialDistance(CDR3_i, CDR3_j);
				double thres = Variable.EditDistThes;
				if ((dist/(double)CDR3_i.length() < thres) || (dist/(double)CDR3_j.length() < thres))
				{
					Data[i][j] = 1;
					Data[j][i] = 1;
				}
				else
				{
					Data[i][j] = 0;
					Data[j][i] = 0;
				}
			}
		}
	}
	
	public void Print(String fileName) throws IOException
	{
		BufferedWriter file = new BufferedWriter(new FileWriter(fileName));
		System.out.println("Graph size = "+Size);
		for (int i = 0; i < Size; i++)
		{
			for (int j = 0; j < Size; j++)
				if (i > j)
					file.write(" ");
				else
					if (Data[i][j] == 1)
						file.write(9608);
					else
						if (Data[i][j] == 0)
							file.write(" ");
						else
						{
							System.out.println("Incorrect symbol in Data!");
							System.exit(0);
						}
			file.write("\n");
		}
		file.close();
	}
}

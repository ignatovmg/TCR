package classes;

import java.lang.*;
import java.util.*;
import java.io.*;

public class Table
{
	int AlphaNum;
	int BetaNum;
	
	public Vector<AlphaChain> AlphaArray;
	public Vector<BetaChain> BetaArray;
	
	int[][] AlphaGraph;
	int[][] BetaGraph;
	
	Vector Clasters;
	
	public void GraphFill()
	{
		if (AlphaArray.isEmpty())
		{
			if (BetaArray.isEmpty())
			{
				System.out.println("Table is empty!");
				System.exit(0);
			}
			else
			{
				BetaGraph = new int[BetaNum][BetaNum];
				this.BetaGraphFill();
			}
		}
		else
		{
			if (BetaArray.isEmpty())
			{
				AlphaGraph = new int[AlphaNum][AlphaNum];
				this.AlphaGraphFill();
			}

			BetaGraph = new int[BetaNum][BetaNum];
			this.BetaGraphFill();
			AlphaGraph = new int[AlphaNum][AlphaNum];
			this.AlphaGraphFill();
		}
	}
	
	public void AlphaGraphFill()
	{
		for (int i = 0; i < AlphaNum; i++)
		{
			for (int j = i; j < AlphaNum; j++)
			{
				if (AlphaArray.get(i).Antigen.equals(AlphaArray.get(j).Antigen))
					AlphaGraph[i][j] = 1;
				else
					AlphaGraph[i][j] = 0;
			}
		}
	}
	
	public void BetaGraphFill()
	{
		for (int i = 0; i < BetaNum; i++)
		{
			for (int j = i; j < BetaNum; j++)
			{
				if (BetaArray.get(i).Antigen.equals(BetaArray.get(j).Antigen))
					BetaGraph[i][j] = 1;
				else
					BetaGraph[i][j] = 0;
			}
		}
	}
	
	public void ClasterObvious()
	{
		Clasters = new Vector();
		if (AlphaArray != null)
			if (!AlphaArray.isEmpty())
			{
				Vector<AlphaChain> AlphaCopy = (Vector<AlphaChain>)AlphaArray.clone();
				for (int i = 0; i < AlphaCopy.size();)
				{
					Vector bufer = new Vector();
					for (int j = i + 1; j < AlphaCopy.size(); j++)
					{
						if (AlphaCopy.get(i).Antigen.equals(AlphaCopy.get(j).Antigen))
						{
							bufer.addElement(AlphaCopy.get(j).Number);
							AlphaCopy.remove(j);
						}
					}
					AlphaCopy.remove(i);
					Clasters.addElement(bufer);
				}
			}
			
		if (BetaArray != null)
			if (!BetaArray.isEmpty())
			{
				Vector<BetaChain> BetaCopy = (Vector<BetaChain>)BetaArray.clone();
				for (int i = 0; i < BetaCopy.size();)
				{
					Vector bufer = new Vector();
					for (int j = i + 1; j < BetaCopy.size(); j++)
					{
						if (BetaCopy.get(i).Antigen.equals(BetaCopy.get(j).Antigen))
						{
							bufer.addElement(BetaCopy.get(j).Number);
							BetaCopy.remove(j);
							//System.out.println(BetaCopy.size()+"| j = "+j+"| i= "+i);
						}
					}
					BetaCopy.remove(i);
					Clasters.addElement(bufer);
				}
			}
	}
	
//===================================================================================
//================= Routine functions ===============================================
//===================================================================================

	public void ReadSampleTable() throws IOException
	{
		BufferedReader file = new BufferedReader(new FileReader("data/vdjdb.txt"));
		String line;
		file.readLine();
		int i = 0;
		int bflag = 0;
		int aflag = 0;
		while((line = file.readLine()) != null)
		{
			String[] list = line.split("\t");
			if (list[3].equals("TRB"))
			{
				if (bflag == 0)
				{
					BetaArray = new Vector<BetaChain>();
					bflag = 1;
				}
				if (!list[8].equals("."))
				{
					BetaArray.addElement(new BetaChain(new String("."), 
						new String("."), 
						new int[]{-2, -2},
						list[1],
						new int[]{-2, -2},
						list[2],
						new int[]{-2, -2},
						new String("."),
						new int[]{-2, -2},
						new String("."),
						list[0]));
					BetaArray.get(i).Number = i;
					BetaArray.get(i).Antigen = list[8];
					i++;
				}
			}
			else
				if (list[3].equals("TRA"))
				{
					if (aflag == 0)
					{
						AlphaArray = new Vector<AlphaChain>();
						aflag = 1;
					}
					if (!list[8].equals("."))
					{
						AlphaArray.addElement(new AlphaChain(new String("."), 
							new String("."), 
							new int[]{-2, -2},
							list[1],
							new int[]{-2, -2},
							list[2],
							new int[]{-2, -2},
							new String("."),
							list[0]));
						AlphaArray.get(i).Number = i;
						AlphaArray.get(i).Antigen = list[8];
						i++;
					}
				}
		}
	}
	
	public void AlphaRead(String fileName) throws IOException
	{
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		String line;
		AlphaArray = new Vector<AlphaChain>();
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
				AlphaArray.get(i).Number = i;
				i++;
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
		BetaArray = new Vector<BetaChain>();
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
				BetaArray.get(i).Number = i;
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
			buf = AlphaArray.get(i);
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
			buf = BetaArray.get(i);
			buf.Write(file);
			file.write("\n");
		}
		file.close();
	}	
}
	

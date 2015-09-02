package classes;

import java.lang.*;
import java.io.*;
import java.util.*;

public class Utilities
{
	public static void SortByAntigen(Vector<Chain> array)
	{
		MistakeEmptyCheck(array, "SortByAntigen");
		int len = array.size();
		for (int i = 0; i < len; i++)
			for (int j = i+1; j < len; j++)
			{
				if (array.get(i).Antigen.equals(array.get(j).Antigen))
				{
					array.insertElementAt(array.get(j), i+1);
					array.remove(j);
					i++;
				}
			}
	}
	
	public static int EditorialDistance(String a, String b)
	{
		int len_a = a.length();
		int len_b = b.length();
		boolean flag = false;
		int [][] cols = new int [2][len_a+1];
		int index1 = 0;
		int index2 = 1;
		for (int i = 0; i <= len_a; i++)
			cols[0][i] = i;
		for (int i = 1; i <= len_b; i++)
		{
			if (flag)
			{
				index2 = 0;
				index1 = 1;
			}
			else 
			{
				index2 = 1;
				index1 = 0;
			}
				
			for (int j = 0; j <= len_a; j++)
			{
				if (j == 0)
					cols[index2][0] = i;
				else
					if (b.charAt(i-1) == a.charAt(j-1))
						cols[index2][j] = cols[index1][j-1];
					else
						cols[index2][j] = Min3(cols[index1][j-1], cols[index1][j], cols[index2][j-1])+1;
						
			}
			if (flag)
				flag = false;
			else
				flag = true;
		}
		return cols[index2][len_a];
	}
	
	public static int Min3(int a, int b, int c)
	{
		return Math.min(c, Math.min(a, b));
	}
	
	public static void MistakeEmptyCheck(Vector array, String s)
	{
		if (array == null)
		{
			System.out.println(s+": Array is NULL!");
			System.exit(0);
		}
		if (array.isEmpty())
		{
			System.out.println(s+": Array is Empty!");
			System.exit(0);
		}
	}
}

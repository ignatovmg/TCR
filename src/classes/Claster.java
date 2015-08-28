package classes;

import java.lang.*;
import java.io.*;
import java.util.*;

public class Claster
{
	Vector Group;
	
	Claster()
	{
		Group = new Vector<Chain>();
	}
	
	public void AddChain(Chain c)
	{
		Chain d = new Chain();
		c.Copy(d);
		Group.addElement(d);
	}
}

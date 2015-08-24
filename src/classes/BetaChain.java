package classes;

import java.lang.*;
import java.io.*;

public class BetaChain extends Chain
{
	int[] DReg;
	String DRegName;
	
	BetaChain(String i, String S, int[] V, String Vname, int[] D,  String Dname, int[] J,  String Jname, int[] C,  String Cname, String CDR)
	{
		Id = i;
		Seq = S;
		VReg = V;
		JReg = J;
		CReg = C;
		DReg = D;
		CDR3 = CDR;
		VRegName = Vname;
		JRegName = Jname;
		CRegName = Cname;
		DRegName = Dname;
	}
	
	public void Write(BufferedWriter file) throws IOException
	{
		file.write("Id = "+Id+
			"\nSeq = "+Seq+
			"\nVReg = "+VReg[0]+"|"+VReg[1]+
			"\nVRegName = "+VRegName+
			"\nDReg = "+DReg[0]+"|"+DReg[1]+
			"\nDRegName = "+DRegName+
			"\nJReg = "+JReg[0]+"|"+JReg[1]+
			"\nJRegName = "+JRegName+
			"\nCReg = "+CReg[0]+"|"+CReg[1]+
			"\nCRegName = "+CRegName+
			"\nCDR3 = "+CDR3);
	}
	
	public void Show()
	{
		System.out.println("Id = "+Id+
			"\nSeq = "+Seq+
			"\nVReg = "+VReg[0]+"|"+VReg[1]+
			"\nVRegName = "+VRegName+
			"\nDReg = "+DReg[0]+"|"+DReg[1]+
			"\nDRegName = "+DRegName+
			"\nJReg = "+JReg[0]+"|"+JReg[1]+
			"\nJRegName = "+JRegName+
			"\nCReg = "+CReg[0]+"|"+CReg[1]+
			"\nCRegName = "+CRegName+
			"\nCDR3 = "+CDR3);
	}
	
	public String getD()
	{
		return Seq.substring(DReg[0], DReg[1]);
	}
}

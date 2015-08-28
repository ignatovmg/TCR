package classes;

import java.lang.*;
import java.io.*;

public class AlphaChain extends Chain
{	
	public AlphaChain(String i, String S, int[] V, String Vname, int[] J, String Jname, int[] C, String Cname, String CDR)
	{
		Id = i;
		Seq = S;
		VReg = V;
		JReg = J;
		CReg = C;
		CDR3 = CDR;
		VRegName = Vname;
		JRegName = Jname;
		CRegName = Cname;
		Antigen = "unknown";
	}
	
	
	public void Write(BufferedWriter file) throws IOException
	{
		file.write("Id = "+Id+
			"\nSeq = "+Seq+
			"\nVReg = "+VReg[0]+"|"+VReg[1]+
			"\nVRegName = "+VRegName+
			"\nJReg = "+JReg[0]+"|"+JReg[1]+
			"\nJRegName = "+JRegName+
			"\nCReg = "+CReg[0]+"|"+CReg[1]+
			"\nCRegName = "+CRegName+
			"\nCDR3 = "+CDR3+
			"\nAntigen = "+Antigen);
	}
	
	public void Show()
	{
		System.out.println("Id = "+Id+
			"\nSeq = "+Seq+
			"\nVReg = "+VReg[0]+"|"+VReg[1]+
			"\nVRegName = "+VRegName+
			"\nJReg = "+JReg[0]+"|"+JReg[1]+
			"\nJRegName = "+JRegName+
			"\nCReg = "+CReg[0]+"|"+CReg[1]+
			"\nCRegName = "+CRegName+
			"\nCDR3 = "+CDR3+
			"\nAntigen = "+Antigen);
	}
}

package classes;

import java.lang.*;
import java.io.*;

public class Chain
{
	String Id;
	int Number;
	
	String ChainFlag;// TRB/TRA
	
	String Seq;
	int[] VReg;
	String VRegName;
	int[] JReg;
	String JRegName;
	int[] CReg;	// Optional
	String CRegName;// Optional
	int[] DReg;	// Optional
	String DRegName;// Optional
	
	String CDR3;
	
	String Antigen;	// Optional
	
	Chain(String CFlag, String i, String S, int[] V, String Vname, int[] D,  String Dname, int[] J,  String Jname, int[] C,  String Cname, String CDR)
	{
		Id = i;
		ChainFlag = CFlag;
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
		Antigen = "unknown";
	}
	
	public void Write(BufferedWriter file) throws IOException
	{
		file.write("Chain = "+ChainFlag+
			"\nId = "+Id+
			"\nSeq = "+Seq+
			"\nVReg = "+VReg[0]+"|"+VReg[1]+
			"\nVRegName = "+VRegName+
			"\nDReg = "+DReg[0]+"|"+DReg[1]+
			"\nDRegName = "+DRegName+
			"\nJReg = "+JReg[0]+"|"+JReg[1]+
			"\nJRegName = "+JRegName+
			"\nCReg = "+CReg[0]+"|"+CReg[1]+
			"\nCRegName = "+CRegName+
			"\nCDR3 = "+CDR3+
			"\nAntigen = "+Antigen);
	}
	
	public void Show()
	{
		System.out.println("Chain = "+ChainFlag+
			"\nId = "+Id+
			"\nSeq = "+Seq+
			"\nVReg = "+VReg[0]+"|"+VReg[1]+
			"\nVRegName = "+VRegName+
			"\nDReg = "+DReg[0]+"|"+DReg[1]+
			"\nDRegName = "+DRegName+
			"\nJReg = "+JReg[0]+"|"+JReg[1]+
			"\nJRegName = "+JRegName+
			"\nCReg = "+CReg[0]+"|"+CReg[1]+
			"\nCRegName = "+CRegName+
			"\nCDR3 = "+CDR3+
			"\nAntigen = "+Antigen);
	}
	
	public String getV()
	{
		return Seq.substring(VReg[0], VReg[1]);
	}
	
	public String getJ()
	{
		return Seq.substring(JReg[0], JReg[1]);
	}
	
	public String getC()
	{
		return Seq.substring(CReg[0], CReg[1]);
	}
	
	public String getD()
	{
		return Seq.substring(DReg[0], DReg[1]);
	}
	
	public String getCDR3()
	{
		return CDR3;
	}
	
	public String getSeq()
	{
		return Seq;
	}
	
	public String getId()
	{
		return Id;
	}
}

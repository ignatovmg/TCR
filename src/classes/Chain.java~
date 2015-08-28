package classes;

import java.lang.*;

public class Chain
{
	String Id;
	int Number;
	String ChainFlag;
	String Seq;
	int[] VReg;
	String VRegName;
	int[] JReg;
	String JRegName;
	int[] CReg;	// Optional
	String CRegName;
	String CDR3;
	
	String Antigen;	// Optional
	
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

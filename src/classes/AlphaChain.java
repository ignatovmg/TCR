package classes;

import java.lang.*;
import java.io.*;

public class AlphaChain extends Chain
{	
	public AlphaChain(String i, String S, int[] V, int[] J, int[] C, String CDR)
	{
		Id = i;
		Seq = S;
		VReg = V;
		JReg = J;
		CReg = C;
		CDR3 = CDR;
	}
	
	
	public void Write(BufferedWriter file) throws IOException
	{
		file.write(Id+"|"+Seq+"|"+VReg[0]+"|"+VReg[1]+"|"+JReg[0]+"|"+JReg[1]+"|"+CReg[0]+"|"+CReg[1]+"|"+CDR3);
	}
	
	public void Show()
	{
		System.out.println(Id+"|"+Seq+"|"+VReg[0]+"|"+VReg[1]+"|"+JReg[0]+"|"+JReg[1]+"|"+CReg[0]+"|"+CReg[1]+"|"+CDR3);
	}
}

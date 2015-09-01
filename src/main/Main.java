package main;

import java.lang.*;
import classes.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
    	Table t = new Table();
    	//t.AlphaRead("generated/alpha_list.txt");
    	//t.AlphaWrite("generated/alpha_test.txt");
    	//t.BetaRead("generated/beta_list.txt");
    	//t.BetaWrite("generated/beta_test.txt");
    	t.ReadSampleTable();
    	//t.BetaArray.get(3).Show();
    	//t.ClasterObvious();
    	t.BetaGraph = new Graph();
    	t.BetaGraph.GraphFill(t.BetaArray, 0);
    	t.BetaGraph.Print("generated/beta_graph0.txt");
    	t.BetaGraph.GraphFill(t.BetaArray, 1);
    	t.BetaGraph.Print("generated/beta_graph1.txt");
    	//System.out.println("\n\nDistance: "+Utilities.EditorialDistance("fabckf", "fahbcf"));
    	
    	
    }
}

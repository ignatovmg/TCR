package main;

import java.io.IOException;
import java.util.Collections;
import classes.Table;
import classes.Chain;
import classes.Graph;

public class Main
{
    public static void main(String[] args) throws IOException
    {
    	Table t = new Table();
    	//t.AlphaRead("generated/alpha_list.txt");
    	//t.AlphaWrite("generated/alpha_test.txt");
    	//t.BetaRead("generated/beta_list.txt");
    	t.ReadSampleTable();
    	//t.BetaWrite("generated/beta_test1.txt");
    	//System.out.println(t.BetaNum);
    	Collections.sort(t.BetaArray, Chain.sortByAntigen());
    	t.BetaGraph = new Graph();
    	t.BetaGraph.GraphFill(t.BetaArray, 0);
    	t.BetaGraph.PrintHeatMap("generated/results/beta_graph_real.txt");
    	t.BetaGraph.GraphFill(t.BetaArray, 2);
    	t.BetaGraph.PrintHeatMap("generated/results/beta_graph_heat.txt");

	/*Formatter fmt = new Formatter();
	fmt.format("%.2f", Variable.EditDistThesh);
	String str = fmt.toString();
    	t.BetaGraph.PrintPseudoGraph("generated/results/beta_graph_thesh_=_"+str+".txt");*/
    	//System.out.println("\n\nDistance: "+Utilities.EditorialDistance("fabckf", "fahbcf"));
    	
    	
    }
}

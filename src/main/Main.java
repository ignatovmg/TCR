package main;

import java.lang.*;
import classes.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
    	Table t = new Table();
    	t.BetaRead("generated/list.txt");
    	t.BetaWrite("generated/test.txt");
    }
}

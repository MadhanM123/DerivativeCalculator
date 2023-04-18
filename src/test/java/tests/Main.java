package tests;

import parser.TokenException;
import parser.TreeBuilder;
import syntaxtree.Op;

public class Main {
    
    public static void main(String[] args) throws TokenException {
        
        TreeBuilder tree = new TreeBuilder("3*(x^2)");
        Op derivative = tree.getTree().derivative();
        System.out.println(derivative.toString());
        
    }
}

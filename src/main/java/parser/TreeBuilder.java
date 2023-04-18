package parser;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import syntaxtree.*;
import net.objecthunter.exp4j.tokenizer.*;

public class TreeBuilder {
    private String str;
    private static Iterator<Token> iter = null;

    public TreeBuilder(String str){
        if(str == null) throw new IllegalArgumentException("Expression cannot be null");
        this.str = str;
        
        ExpParser expBuilder = new ExpParser(str);
        List<Token> li = Arrays.asList(expBuilder.var("x").build());
        Collections.reverse(li);
        iter = li.iterator();
    }

    private Op getFunc(Token t) throws TokenException{
        FunctionToken ft = (FunctionToken) t;
        
        switch(ft.getFunction().getName()){
            case "abs": return new Abs(getTree());
            case "acos": return new Acos(getTree());
            case "asin": return new Asin(getTree());
            case "atan": return new Atan(getTree());
            case "cos": return new Cos(getTree());
            case "exp": return new Exp(getTree());
            case "log": return new Log(getTree());
            case "sin": return new Sin(getTree());
            case "sqrt": return new Sqrt(getTree());
            case "tan": return new Tan(getTree());
            default: throw new TokenException("Function Error");
        }
    }

    private Op getOp(Token t) throws TokenException{
        Op right = getTree();
        Op left = getTree();

        switch(((OperatorToken)t).getOperator().getSymbol()){
            case "+": return new Add(left, right);
            case "-": return new Subtract(left, right);
            case "*": return new Multiply(left, right);
            case "/": return new Divide(left, right);
            case "^": return new Pow(left, right);
            default: throw new TokenException("Operator Error");
        }
    }

    private Op getTree() throws TokenException{
        Token t = iter.next();

        switch(t.getType()){
            case Token.TOKEN_NUMBER: return new Constant(""+ ((NumberToken)t).getValue());
            case Token.TOKEN_OPERATOR: return getOp(t);
            case Token.TOKEN_FUNCTION: return getFunc(t);
            case Token.TOKEN_PARENTHESES_OPEN: return getTree();
            case Token.TOKEN_PARENTHESES_CLOSE: return getTree();
            case Token.TOKEN_VARIABLE: return new SimpleVar();
            default: throw new TokenException("Invalid expression");
        }
    }
}

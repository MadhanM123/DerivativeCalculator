package parser;

import java.util.*;

import net.objecthunter.exp4j.function.Function;
import net.objecthunter.exp4j.function.Functions;
import net.objecthunter.exp4j.operator.Operator;
import net.objecthunter.exp4j.shuntingyard.ShuntingYard;
import net.objecthunter.exp4j.tokenizer.Token;

public class ExpParser {
    
    private final String exp;

    private final Map<String, Function> useFuncs;
    
    private final Map<String, Operator> useOps;

    private final Set<String> varNames;

    private boolean implicitMultiply = true;

    public ExpParser(String exp){
        if(exp == null || exp.trim().length() == 0){
            throw new IllegalArgumentException("Expression cannot be empty");
        }
        this.exp = exp;
        this.useFuncs = new HashMap<>(4);
        this.useOps = new HashMap<>(4);
        this.varNames = new HashSet<>(4);
    }

    public ExpParser func(Function func){
        this.useFuncs.put(func.getName(), func);
        return this;
    }

    public ExpParser funcs(Function[] funcs){
        for(Function func : funcs){
            this.useFuncs.put(func.getName(), func);
        }
        return this;
    }

    public ExpParser funcs(List<Function> funcs){
        for(Function func : funcs){
            this.useFuncs.put(func.getName(), func);
        }
        return this;
    }

    public ExpParser var(String var){
        this.varNames.add(var);
        return this;
    }

    public ExpParser vars(Set<String> varNames){
        this.varNames.addAll(varNames);
        return this;
    }

    public ExpParser vars(String[] varNames){
        Collections.addAll(this.varNames, varNames);
        return this;
    }

    public ExpParser implicitMultiply(boolean enabled){
        this.implicitMultiply = enabled;
        return this;
    }

    public ExpParser operator(Operator op){
        this.checkOpSymbol(op);
        this.useOps.put(op.getSymbol(), op);
        return this;
    }

    private void checkOpSymbol(Operator op){
        String name = op.getSymbol();
        for(char ch : name.toCharArray()){
            if(!Operator.isAllowedOperatorChar(ch)){
                throw new IllegalArgumentException("The operator symbol '" + name + "' is not allowed");
            }
        }
    }

    public ExpParser operators(Operator[] ops){
        for(Operator op : ops){
            this.operator(op);
        }
        return this;
    }

    public ExpParser operators(List<Operator> ops){
        for(Operator op : ops){
            this.operator(op);
        }
        return this;
    }

    public Token[] build(){
        if(exp.length() == 0){
            throw new IllegalArgumentException("Expression cannot be empty");
        }

        this.constants();

        for(String var : varNames){
            if(Functions.getBuiltinFunction(var) != null || useFuncs.containsKey(var)){
                throw new IllegalArgumentException("Duplicated function as variable");
            }
        }

        Token[] tokens = ShuntingYard.convertToRPN(exp, useFuncs, useOps, varNames, implicitMultiply);

        return tokens;
    }

    private void constants(){
        varNames.add("pi");
        varNames.add("π");
        varNames.add("e");
        varNames.add("φ");
    }
}

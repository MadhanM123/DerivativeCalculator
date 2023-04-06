package com.mad.function;

/*
 * A class representing a function which can be used in an expression
 */
public abstract class Function {
    private final String name;

    protected final int numArgs;

    public Function(String name, int numArgs){
        if(numArgs < 0){
            throw new IllegalArgumentException("Number of arguments must be greater than 0");
        }
        if(!isValidName(name)){
            throw new IllegalArgumentException("Name is invalid");
        }
        this.name = name;
        this.numArgs = numArgs;
    }

    public Function(String name){
        this(name, 1);
    }

    public String getName(){
        return name;
    }

    public int getNumArgs(){
        return numArgs;
    }

    public abstract double apply(double... args);

    public static boolean isValidName(String name){
        if(name == null){
            return false;
        }

        final int sz = name.length();

        if(sz == 0){
            return false;
        }

        for(int i = 0; i < sz; i++){
            final char c = name.charAt(i);
            if(Character.isLetter(c) || c == '_'){
                continue;
            }
            else if(Character.isDigit(c) && i > 0){
                continue;
            }
            
            return false;
        }

        return true;
    }

}

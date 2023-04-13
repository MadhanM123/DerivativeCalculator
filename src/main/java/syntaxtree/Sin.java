package syntaxtree;

public class Sin extends UnaryOp {

    public Sin(Op op){
        super(op);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Sin)) return false;
        Sin oth = (Sin) o;
        return this.op.equals(oth.op);
    }

    @Override
    public int hashCode()
    {
        return 47 * op.hashCode();
    }

    @Override
    public String toString()
    {
        return "sin(" + op.toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.sin(op.getNumResult(in));
    }
    
}

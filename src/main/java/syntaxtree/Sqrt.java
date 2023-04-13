package syntaxtree;

public class Sqrt extends UnaryOp {

    public Sqrt(Op op){
        super(op);
    }

    @Override
    public boolean equals(Object op)
    {
        if(this == op) return true;
        if(!(op instanceof Sqrt)) return false;
        Sqrt oth = (Sqrt) op;
        return this.op.equals(oth.op);
    }

    @Override
    public int hashCode()
    {
        return 53 * op.hashCode();
    }

    @Override
    public String toString()
    {
        return "sqrt(" + op.toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.sqrt(op.getNumResult(in));
    }
    
}

package syntaxtree;

public class Exp extends UnaryOp {

    public Exp(Op op){
        super(op);
    }

    @Override
    public boolean equals(Object op)
    {
        if(this == op) return true;
        if(!(op instanceof Exp)) return false;
        Exp oth = (Exp) op;
        return this.op.equals(oth.op);
    }

    @Override
    public int hashCode()
    {
        return 31 * op.hashCode();
    }

    @Override
    public String toString()
    {
        return "e^(" + op.toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.exp(op.getNumResult(in));
    }
    
}

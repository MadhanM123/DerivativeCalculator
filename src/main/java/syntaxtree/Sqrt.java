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
        return this.getOp().equals(oth.getOp());
    }

    @Override
    public int hashCode()
    {
        return 53 * this.getOp().hashCode();
    }

    @Override
    public String toString()
    {
        return "sqrt(" + this.getOp().toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.sqrt(this.getOp().getNumResult(in));
    }
    
}

package syntaxtree;

public class Negate extends UnaryOp {

    public Negate(Op op){
        super(op);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(!(obj instanceof Negate)) return false;
        Negate other = (Negate) obj;
        return this.op.equals(other.op);
    }

    @Override
    public int hashCode()
    {
        return 41 * this.op.hashCode();
    }

    @Override
    public String toString()
    {
        return "-" + this.op.toString();
    }

    @Override
    public double getNumResult(double in)
    {
        return -this.op.getNumResult(in);
    }

    
}

package syntaxtree;

public class Acos extends UnaryOp {
    
    public Acos(Op op){
        super(op);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Acos)) return false;
        Acos oth = (Acos) o;
        return this.op.equals(oth.op);
    }

    @Override
    public int hashCode()
    {
        return 11 * op.hashCode();
    }

    @Override
    public String toString()
    {
        return "acos(" + op.toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.acos(op.getNumResult(in));
    }

    
}

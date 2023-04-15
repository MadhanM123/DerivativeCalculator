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
        return this.getOp().equals(oth.getOp());
    }

    @Override
    public int hashCode()
    {
        return 11 * this.getOp().hashCode();
    }

    @Override
    public String toString()
    {
        return "acos(" + this.getOp().toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.acos(this.getOp().getNumResult(in));
    }

    
}

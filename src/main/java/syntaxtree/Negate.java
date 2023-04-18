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
        return this.getOp().equals(other.getOp());
    }

    @Override
    public int hashCode()
    {
        return 41 * this.getOp().hashCode();
    }

    @Override
    public String toString()
    {
        return "-" + this.getOp().toString();
    }

    @Override
    public double getNumResult(double in)
    {
        return -this.getOp().getNumResult(in);
    }

    @Override
    public Op derivative()
    {
        return new Negate(this.getOp().derivative());
    }

    

    
}

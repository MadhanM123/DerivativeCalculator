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
        return this.getOp().equals(oth.getOp());
    }

    @Override
    public int hashCode()
    {
        return 31 * this.getOp().hashCode();
    }

    @Override
    public String toString()
    {
        return "e^(" + this.getOp().toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.exp(this.getOp().getNumResult(in));
    }

    @Override
    public Op derivative()
    {
        //e^x = e^x * x'
        
        return new Multiply(new Exp(this.getOp()), this.getOp().derivative());
    }
}

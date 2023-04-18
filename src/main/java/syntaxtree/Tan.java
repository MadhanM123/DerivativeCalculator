package syntaxtree;

public class Tan extends UnaryOp {

    public Tan(Op op){
        super(op);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Tan)) return false;
        Tan oth = (Tan) o;
        return this.getOp().equals(oth.getOp());
    }

    @Override
    public int hashCode()
    {
        return 59 * this.getOp().hashCode();
    }

    @Override
    public String toString()
    {
        return "tan(" + this.getOp().toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.tan(this.getOp().getNumResult(in));
    }

    @Override
    public Op derivative()
    {
        return new Divide(this.getOp().derivative(),
            new Pow(new Cos(this.getOp()), new Constant("2")));
    }

    
    
}

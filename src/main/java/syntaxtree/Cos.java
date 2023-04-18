package syntaxtree;

public class Cos extends UnaryOp {

    public Cos(Op op){
        super(op);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Cos)) return false;
        Cos oth = (Cos) o;
        return this.getOp().equals(oth.getOp());
    }

    @Override
    public int hashCode()
    {
        return 29 * this.getOp().hashCode();
    }

    @Override
    public String toString()
    {
        return "cos(" + this.getOp().toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.cos(this.getOp().getNumResult(in));
    }

    @Override
    public Op derivative()
    {
        return new Negate(new Multiply(new Sin(this.getOp()), this.getOp().derivative()));
    } 
}

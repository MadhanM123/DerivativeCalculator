package syntaxtree;

public class Sin extends UnaryOp {

    public Sin(Op op){
        super(op);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Sin)) return false;
        Sin oth = (Sin) o;
        return this.getOp().equals(oth.getOp());
    }

    @Override
    public int hashCode()
    {
        return 47 * this.getOp().hashCode();
    }

    @Override
    public String toString()
    {
        return "sin(" + this.getOp().toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.sin(this.getOp().getNumResult(in));
    }

    @Override
    public Op derivative()
    {
        //Multiply for chain rule
        return new Multiply(new Cos(this.getOp()), this.getOp().derivative());
    }

    
    
}

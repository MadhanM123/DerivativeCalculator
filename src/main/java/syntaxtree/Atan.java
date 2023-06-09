package syntaxtree;

public class Atan extends UnaryOp {
    
    public Atan(Op op){
        super(op);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Atan)) return false;
        Atan oth = (Atan) o;
        return this.getOp().equals(oth.getOp());
    }

    @Override
    public int hashCode()
    {
        return 17 * this.getOp().hashCode();
    }

    @Override
    public String toString()
    {
        return "atan(" + this.getOp().toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.atan(this.getOp().getNumResult(in));
    }

    @Override
    public Op derivative()
    {
        //(1/1+x^2) * x'
        return new Divide(this.getOp().derivative(), 
        new Add(new Constant("1"), new Pow(this.getOp(), new Constant("2"))));
    }

    

    
}

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
        return this.op.equals(oth.op);
    }

    @Override
    public int hashCode()
    {
        return 29 * op.hashCode();
    }

    @Override
    public String toString()
    {
        return "cos(" + op.toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.cos(op.getNumResult(in));
    }
    
}

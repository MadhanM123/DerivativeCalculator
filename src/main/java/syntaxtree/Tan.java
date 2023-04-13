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
        return this.op.equals(oth.op);
    }

    @Override
    public int hashCode()
    {
        return 59 * op.hashCode();
    }

    @Override
    public String toString()
    {
        return "tan(" + op.toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.tan(op.getNumResult(in));
    }
    
}

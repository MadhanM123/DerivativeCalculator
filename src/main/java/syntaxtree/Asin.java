package syntaxtree;

public class Asin extends UnaryOp {

    public Asin(Op op){
        super(op);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Asin)) return false;
        Asin oth = (Asin) o;
        return this.getOp().equals(oth.getOp());
    }

    @Override
    public int hashCode()
    {
        return 13 * this.getOp().hashCode();
    }

    @Override
    public String toString()
    {
        return "asin(" + this.getOp().toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.asin(this.getOp().getNumResult(in));
    }

    


}

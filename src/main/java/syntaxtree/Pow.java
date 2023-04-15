package syntaxtree;

public class Pow extends BinaryOp{
            
    public Pow(Op left, Op right){
        super(left, right);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Pow)) return false;
        Pow oth = (Pow) o;
        return this.getLeft().equals(oth.getLeft()) && this.getRight().equals(oth.getRight());
    }

    @Override
    public int hashCode()
    {
        return 71 * (this.getLeft().hashCode() + this.getRight().hashCode());
    }

    @Override
    public String toString()
    {
        return "(" + this.getLeft().toString() + ")^(" + this.getRight().toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.pow(this.getLeft().getNumResult(in), this.getRight().getNumResult(in));
    }
    
}

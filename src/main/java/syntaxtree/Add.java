package syntaxtree;

public class Add extends BinaryOp{
    
    public Add(Op left, Op right){
        super(left, right);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Add)) return false;
        Add oth = (Add) o;
        return this.getLeft().equals(oth.getLeft()) && this.getRight().equals(oth.getRight());
    }

    @Override
    public int hashCode()
    {
        return 61 * (this.getLeft().hashCode() + this.getRight().hashCode());
    }

    @Override
    public String toString()
    {
        return this.getLeft().toString() + "+" + this.getRight().toString();
    }

    @Override
    public double getNumResult(double in)
    {
        return this.getLeft().getNumResult(in) + this.getRight().getNumResult(in);
    }

    @Override
    public Op derivative()
    {
        return new Add(this.getLeft().derivative(), this.getRight().derivative());
    }
    
}

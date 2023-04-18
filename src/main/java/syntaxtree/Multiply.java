package syntaxtree;

public class Multiply extends BinaryOp {
            
    public Multiply(Op left, Op right){
        super(left, right);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Multiply)) return false;
        Multiply oth = (Multiply) o;
        return this.getLeft().equals(oth.getLeft()) && this.getRight().equals(oth.getRight());
    }

    @Override
    public int hashCode()
    {
        return 73 * (this.getLeft().hashCode() + this.getRight().hashCode());
    }

    @Override
    public String toString()
    {
        return "(" + this.getLeft().toString() + ")*(" + this.getRight().toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return this.getLeft().getNumResult(in) * this.getRight().getNumResult(in);
    }

    @Override
    public Op derivative()
    {
        //Product rule
        return new Add(new Multiply(this.getLeft().derivative(), this.getRight()),
         new Multiply(this.getLeft(), this.getRight().derivative()));
    }

    
    
}

package syntaxtree;

public class Divide extends BinaryOp {
        
    public Divide(Op left, Op right){
        super(left, right);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Divide)) return false;
        Divide oth = (Divide) o;
        return this.getLeft().equals(oth.getLeft()) && this.getRight().equals(oth.getRight());
    }

    @Override
    public int hashCode()
    {
        return 67 * (this.getLeft().hashCode() + this.getRight().hashCode());
    }

    @Override
    public String toString()
    {
        return "(" + this.getLeft().toString() + ")/(" + this.getRight().toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return this.getLeft().getNumResult(in) / this.getRight().getNumResult(in);
    }
    
}

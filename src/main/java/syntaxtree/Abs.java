package syntaxtree;

public class Abs extends UnaryOp {

    public Abs(Op op){
        super(op);
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.abs(this.getOp().getNumResult(in));
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(!(obj instanceof Abs)) return false;
        Abs other = (Abs) obj;
        return (this.getOp().equals(other.getOp()));
    }

    @Override
    public int hashCode(){
        return 7 * this.getOp().hashCode();
    }
}

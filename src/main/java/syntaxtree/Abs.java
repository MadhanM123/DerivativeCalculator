package syntaxtree;

public class Abs extends UnaryOp {

    public Abs(Op op){
        super(op);
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.abs(op.getNumResult(in));
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(!(obj instanceof Abs)) return false;
        Abs other = (Abs) obj;
        return (op.equals(other.op));
    }

    @Override
    public int hashCode(){
        return 7 * op.hashCode();
    }
}

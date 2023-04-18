package syntaxtree;

public class Log extends UnaryOp{
    
    public Log(Op op){
        super(op);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Log)) return false;
        Log oth = (Log) o;
        return this.getOp().equals(oth.getOp());
    }

    @Override
    public int hashCode()
    {
        return 37 * this.getOp().hashCode();
    }

    @Override
    public String toString()
    {
        return "log(" + this.getOp().toString() + ")";
    }

    @Override
    public double getNumResult(double in)
    {
        return Math.log(this.getOp().getNumResult(in));
    }

    @Override
    public Op derivative()
    {
        return new Divide(this.getOp().derivative(), this.getOp());
    }

    
}

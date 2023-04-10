package syntaxtree;

public class Constant implements Op {
    private String con;

    public Constant(String con){
        this.con = con;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(!(obj instanceof Constant)) return false;
        Constant other = (Constant) obj;
        return this.con.equals(other.con);
    }

    @Override
    public int hashCode()
    {
        return 23 * (int) Double.parseDouble(con);
    }

    @Override
    public String toString()
    {
        return this.con;
    }

    @Override
    public double getNumResult(double in)
    {
        return Double.parseDouble(con);
    }
}

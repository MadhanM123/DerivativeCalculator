package syntaxtree;

public class SimpleVar implements Op {

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        return (obj instanceof SimpleVar);
    }

    @Override
    public int hashCode()
    {
        return 43;
    }

    @Override
    public String toString()
    {
        return "x";
    }

    @Override
    public double getNumResult(double in)
    {
        return in;
    }
    
}

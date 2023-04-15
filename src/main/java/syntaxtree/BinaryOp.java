package syntaxtree;

import static java.util.Objects.requireNonNull;

public abstract class BinaryOp implements Op{
    final private Op left;
    final private Op right;

    public BinaryOp(Op left, Op right){
        this.left = requireNonNull(left,"left op must not be null");
        this.right = requireNonNull(right, "right op must not be null");
    }

    public Op getLeft(){
        return left;
    }

    public Op getRight(){
        return right;
    }
}
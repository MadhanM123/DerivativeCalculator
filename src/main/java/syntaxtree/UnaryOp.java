package syntaxtree;

import static java.util.Objects.requireNonNull;

public abstract class UnaryOp implements Op {
    final protected Op op;

    public UnaryOp(Op op){
        this.op = requireNonNull(op, "op must not be null");
    }

    public Op getOp(){
        return op;
    }
}

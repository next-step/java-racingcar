package step2;

/**
 * step2.ExpressionPart : 피연산자
 */
public class Operand implements ExpressionPart{

    private Integer value;

    public Operand(Integer value){
        this.value = value;
    }

    @Override
    public Type type() {
        return Type.Operand;
    }

    public Integer getValue(){
        return value;
    }
}

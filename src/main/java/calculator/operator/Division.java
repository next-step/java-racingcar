package calculator.operator;

public class Division implements Operator{
    @Override
    public Long action(Long x, Long y){
        return x/y;
    }
}

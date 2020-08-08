package stringCalculator;

public class DivideOperation implements Operation{
    @Override
    public boolean isSupport(String operator){
        return operator.equals("/");
    }

    public int operate(int x, int y){
        return x / y;
    }
}

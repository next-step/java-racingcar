package stringCalculator;

public class MinusOperation implements Operation{
    @Override
    public boolean isSupport(String Operator){
        return Operator.equals("-");
    }

    @Override
    public int operate(int x, int y){
        return x - y;
    }
}

package step2;

public class StringCalculator {


    public int calculate(String expression){
        if(expression == null || expression.isEmpty()){
            return 0;
        }
        return Integer.parseInt(expression);
    }

}

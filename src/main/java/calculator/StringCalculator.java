package calculator;

public class StringCalculator {
    public static final int ZERO = 0;

    public static int splitAndSum(String text){
        int sum = ZERO;
        if(text == null || text.isBlank()){
            sum = ZERO;
        }else{
            sum = Integer.parseInt(text);
        }
        return sum;

    }
}

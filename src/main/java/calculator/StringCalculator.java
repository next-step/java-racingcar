package calculator;

public class StringCalculator {

    public static int calculate(String text){
        String[] values = text.split(" ");

        int result = 0;
        for(int i=0; i < values.length -1; i += 2){
            result = Operator.findOperator(values[i+1]).result(Integer.parseInt(values[i]), Integer.parseInt(values[i+2]));
        }
        return result;

    }

}

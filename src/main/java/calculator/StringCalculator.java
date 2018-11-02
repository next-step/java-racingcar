package calculator;

public class StringCalculator {

    public static int calculate(String text) {
        String[] values = text.split(" ");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);

        int result = calculate(values[1], first, second);

        if(values.length > 3){
            String reValue = String.valueOf(result);
            for(int i=3; i<values.length; i++){
                reValue += values[i];
            }
            System.out.println(reValue);
            calculate(reValue);
        }

        return result;
    }

    public static int calculate (String value,int first, int second){
        if (value.equals("+")) {
            return first + second;
        }
        if (value.equals("-")) {
            return first - second;
        }
        if (value.equals("*")) {
            return first * second;
        }
        if (value.equals("/")) {
            return first / second;
        }
        throw new IllegalArgumentException();
    }

}
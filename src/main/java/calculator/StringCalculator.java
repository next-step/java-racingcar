package calculator;

public class StringCalculator {
    public static int calculate(String exp){
        String[] values = exp.split(" ");
        int result = strToNum(values[0]);
        for(int i = 1; i < values.length-1; i+=2){
            result = getResult(values[i], strToNum(values[i+1]), result);
        }
      return result;
    }

    private static int strToNum(String number) {
        return Integer.parseInt(number);
    }

    private static int getResult(String operation, int number, int result) {
        if(operation.equals("+")){
            result += number;
        }
        if(operation.equals("-")){
            result -= number;
        }
        if(operation.equals("/")){
            result /= number;
        }
        if(operation.equals("*")){
            result *= number;
        }
        if(operation == null){
            throw new NullPointerException();
        }
        if(operation.equals("")){
            throw new IllegalArgumentException();
        }
        return result;
    }

}

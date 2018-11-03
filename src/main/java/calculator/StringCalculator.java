package calculator;

public class StringCalculator {
    //쪼개

    public static int calculate(String exp){
        String[] values = exp.split(" ");
        int result = Integer.parseInt(values[0]);
        for(int i = 1; i < values.length-1; i++){
            result = getSum(values, result, i);
        }
      return result;
    }

    private static int getSum(String[] values, int result, int index) {
        if(values[index].equals("+")){
            result += Integer.parseInt(values[index+1]);
        }if(values[index].equals("-")){
            result -= Integer.parseInt(values[index+1]);
        }else  if(values[index].equals("/")){
            result /= Integer.parseInt(values[index+1]);
        }else  if(values[index].equals("*")){
            result *= Integer.parseInt(values[index+1]);
        }
        else if(values[index] == null || values[index+1] == null){
            throw new NullPointerException();
        }else if(values[index].equals("") || values[index+1].equals("")){
            throw new IllegalArgumentException();
        }
        return result;
    }

}

package calculator;

public class StringCalculator {
    //쪼개

    public static int calculate(String text){
        String[] values = text.split(" ");
        int sum = 0;
        for(int i = 0; i < values.length; i++){
            if(i == 0){
                sum = Integer.parseInt(values[i]);
            }else if(i%2 == 1 ){
                if(values[i].equals("+")){
                    sum = add(sum, Integer.parseInt(values[i+1]));
                }else  if(values[i].equals("-")){
                    sum = sub(sum, Integer.parseInt(values[i+1]));
                }else  if(values[i].equals("/")){
                    sum = div(sum, Integer.parseInt(values[i+1]));
                }else  if(values[i].equals("*")){
                    sum = mul(sum, Integer.parseInt(values[i+1]));
                }else{
                    throw new IllegalArgumentException();
                }

            }
        }
      return sum;
    }

    private static int mul(int sum, int i) {
        return sum * i;
    }

    private static int div(int sum, int i) {
        return  sum / i;
    }

    private static int sub(int sum, int i) {
        return sum - i;
    }

    private static int add(int sum, int i) {
        return sum + i ;
    }
}

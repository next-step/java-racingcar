package calculator;

public class Calculator {

    void calculatorInput(String sentence){
        final String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if(!isStringDouble(arr[i].toString())) {
              //  String kind = cal(arr[i].toString());
               // System.out.println(kind);
            }
        }
      /*  assertThatThrownBy(() -> {
          //  abc.charAt(3);
        }).isInstanceOf(IllegalArgumentException.class);*/
    }

    private boolean isStringDouble(String toString) {
        try {
            Double.parseDouble(toString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    int plus (int a, int b){
        String plus = "+";
        return a+b;
    }
    int minus (int a, int b){
        String minus = "-";
        return a-b;
    }
    int multiply (int a, int b){
        String multiply = "*";
        return a*b;
    }
    int  divide(int a, int b){
        String divide = "/";
        return a/b;
    }

}

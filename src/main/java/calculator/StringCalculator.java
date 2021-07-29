package calculator;

public class StringCalculator {

    private StringCalculator() {

    }

    public static int cal(String s) {

        stringValidationChecker(s);

        String[] value = s.split(" ");
        String operator = value[1];

        operatorChecker(operator);

        int temp = Integer.parseInt(value[0]);

        for (int i = 1; i < value.length; i = i+2) {
            temp = calculator(temp, value[i], value[i+1]);
        }

        return temp;
    }

    private static int calculator(int num1, String opr, String stringNum){
        int num2 = Integer.parseInt(stringNum);

        switch (opr){
            case "+" :
                return adder(num1, num2);
            case "-":
                return subtractor(num1, num2);
            case "*" :
                return multiplier(num1, num2);
            case "/":
                return divider(num1, num2);
        }
        return 0;
    }

    private static void stringValidationChecker(String s){
        if(s==null || s.equals("") || s.equals(" "))
        {
            throw new IllegalArgumentException();
        }
    }

    private static void operatorChecker(String operator){
        if(!("+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator))){
            throw new IllegalArgumentException();
        }
    }

    private static Integer adder(int num1, int num2){
        return num1 + num2;
    }

    private static Integer subtractor(int num1, int num2){
        return num1 - num2;
    }

    private static Integer multiplier(int num1, int num2){
        return num1 * num2;
    }

    private static Integer divider(int num1, int num2){
        return num1 / num2;
    }

}

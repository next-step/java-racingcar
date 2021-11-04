package step2.model;

public class Calculator {

    public static MyNumber operator(String str) {
        String[] StringArray = str.split(" ");
        MyNumber result = new MyNumber(StringArray[0]);
        for (int i = 1; i < StringArray.length; i += 2) {
            String operator = StringArray[i];
            MyNumber myNumber2 = new MyNumber(StringArray[i+1]);
            result = calculator(result, myNumber2, operator);
        }
        return result;
    }

    public static MyNumber calculator(MyNumber num1, MyNumber num2, String o) {
        if (o.equals("+")) {
            return num1.add(num2);
        }
        if (o.equals("-")) {
            return num1.minus(num2);
        }
        if (o.equals("*")) {
            return num1.multiply(num2);
        }
        if (o.equals("/")) {
            return num1.divide(num2);
        }
        throw new IllegalArgumentException();
    }



}

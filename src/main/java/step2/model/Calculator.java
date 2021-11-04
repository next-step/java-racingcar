package step2.model;

public class Calculator {

    public static MyNumber operator(String str) {
        String[] value = str.split(" ");
        MyNumber result = new MyNumber(Integer.parseInt(value[0]));
        for (int i = 1; i < value.length; i += 2) {
            String operator = value[i];
            MyNumber myNumber2 = new MyNumber(Integer.parseInt(value[i+1]));
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
            valid(num2);
            return num1.divide(num2);
        }
        throw new IllegalArgumentException();
    }

    public static void valid(MyNumber num2) {
        if (num2.equals(new MyNumber(0))) {
            throw new IllegalArgumentException("나눗셈에서 분모는 0이 될 수 없습니다");
        }
    }

}

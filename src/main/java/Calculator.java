public class Calculator {
    public Calculator(){

    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int sub(int num1, int num2) {
        return num1 - num2;
    }

    public int mul(int num1, int num2) {
        return num1 * num2;
    }

    public float div(int num1, int num2) {
        return num1 / num2;
    }

    public float doBinaryOperation(int num1, int num2, String ope) {
        switch (ope) {
            case "+":
                return add(num1, num2);
            case "-":
                return sub(num1, num2);
            case "*":
                return mul(num1, num2);
            case "/":
                return div(num1, num2);
        }
        return 0;
    }
}

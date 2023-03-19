package calculator;

public class Calculator_Main {

    public static void main(String args[]) {

        String text = "2 + 3 * 4 / 2";
        text = text.replaceAll(" ", "");

        Calculator_Move obj1 = new Calculator_Move();
        System.out.print(text + "=" + obj1.caculate(text));

    }
}

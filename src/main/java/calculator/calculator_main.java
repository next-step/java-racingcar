package calculator;

public class calculator_main {

    public static void main(String args[]){

        String text = "2 + 3 * 4 / 2";
        text = text.replaceAll(" ","");

        calculator_move obj1 = new calculator_move();
        System.out.print(text+"="+ obj1.caculate(text));

    }
}

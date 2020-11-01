package calculator;

public class RunMain {
    public static void main(String args[]){
        String text = "1+3 *2+3";

        System.out.println("============================");
        System.out.println( RunCalculator.runCalculator(text));

    }
}

package step3;

public class Printer {

    private final static String STATE = "-";

    public static void print(int count){
        System.out.println(STATE.repeat(count));
    }
}

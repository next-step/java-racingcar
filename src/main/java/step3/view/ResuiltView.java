package step3.view;

public class ResuiltView {

    private static final String MOVE_PRINT = "-";

    public static void show(int count) {
        System.out.println(MOVE_PRINT.repeat(Math.max(0, count)));
    }
}

package racingcar;

public class Printer {
    public static void print(int count) {
        for (int print = 0; print < count; print++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void print(String printable) {
        System.out.println(printable);
    }
}

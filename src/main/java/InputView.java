import java.util.Scanner;

public class InputView {
    public static int inputInteger() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
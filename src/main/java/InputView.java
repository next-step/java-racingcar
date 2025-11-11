import java.util.Scanner;

public class InputView {
    public static int readCarCountInput() {
        Scanner scanner = new Scanner(System.in);
        print("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int readRoundCountInput() {
        Scanner scanner = new Scanner(System.in);
        print("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private static void print(String text) {
        System.out.println(text);
    }
}

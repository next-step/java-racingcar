import java.util.Scanner;

public final class InputView {

    private InputView() {}

    public static int inputCarNum() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int inputTryNum() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}

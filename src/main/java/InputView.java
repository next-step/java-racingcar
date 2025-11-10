import java.util.Scanner;

public class InputView {
    final int carCount;
    final int gameCount;

    public InputView(int carCount, int gameCount) {
        this.carCount = carCount;
        this.gameCount = gameCount;
    }

    public static InputView readGameInput() {
        Scanner scanner = new Scanner(System.in);
        print("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        print("시도할 회수는 몇 회 인가요?");
        int gameCount = scanner.nextInt();
        return new InputView(carCount, gameCount);
    }

    private static void print(String text) {
        System.out.println(text);
    }
}

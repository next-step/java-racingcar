import java.util.Scanner;

public class InputView {

    public static CarRacing inputCarRacingInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = scanner.nextInt();
        scanner.close();

        return new CarRacing(carCount, moveCount);
    }
}

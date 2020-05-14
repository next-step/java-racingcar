package race;

import java.util.Scanner;

public final class InputView {

    private InputView() {

    }

    public static RacingGame print() {
        Scanner scanner = new Scanner(System.in);
        int count = getCountOfCar(scanner);
        int time = getTime(scanner);

        return RacingGame.of(count, time);
    }

    private static int getCountOfCar(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private static int getTime(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}

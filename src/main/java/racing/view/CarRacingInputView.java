package racing.view;

import java.util.Scanner;

public class CarRacingInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int countOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return SCANNER.nextInt();
    }

    public static int countOfRace() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return SCANNER.nextInt();
    }
}

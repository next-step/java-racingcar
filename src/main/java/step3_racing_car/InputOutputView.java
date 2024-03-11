package step3_racing_car;

import java.util.List;
import java.util.Scanner;

public class InputOutputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printRoundResult(RacingCars racingCars) {
        System.out.println("실행결과");
        for (int i = 0; i < racingCars.getRacingCars().size(); i++) {
            int position = racingCars.getRacingCars().get(i).getPosition();
            String name = racingCars.getRacingCars().get(i).getName();
            System.out.println(name + " : " + "-".repeat(position));
        }
    }

    public static void printGameWinner(RacingCars racingCars) {
        System.out.println();
        for (int i = 0; i < racingCars.getRacingCars().size() - 1; i++) {
            String name = racingCars.getRacingCars().get(i).getName();
            System.out.print(name + ",");
        }
        System.out.println(racingCars.getRacingCars().get(racingCars.getRacingCars().size() - 1));
    }

    public static List<String> scanCarNames() {
        return List.of(scanStringInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).").split(","));
    }

    public static int scanRoundCount() {
        return scanIntInput("시도할 횟수는 몇 회 인가요?");
    }

    private static int scanIntInput(String x) {
        System.out.println(x);
        int participantCarCount = scanner.nextInt();
        return participantCarCount;
    }

    private static String scanStringInput(String x) {
        System.out.println(x);
        String participantCarCount = scanner.nextLine();
        return participantCarCount;
    }
}

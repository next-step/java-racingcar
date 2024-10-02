package racing;

import java.util.Scanner;

public class RacingCarWithNameGame {

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String totalCarNames = scanner.next();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int totalRacingCounts = scanner.nextInt();

        System.out.println("실행 결과");
        start(totalCarNames, totalRacingCounts);

    }

    public static int start(String totalCarNames, int totalRacingCounts) {
        int result = 0;

        RacingCar[] racingCars = readyRacingCars(totalCarNames);

        for (int i = 0; i < totalRacingCounts; i++) {
            result += racing(racingCars);
            ResultView.display(racingCars);
        }

        return result;
    }

    private static RacingCar[] readyRacingCars(String totalCarNames) {
        String[] carNames = splitCarNames(totalCarNames);

        RacingCar[] racingCars = new RacingCar[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            racingCars[i] = new RacingCar(carNames[i], new Operator());
        }
        return racingCars;
    }

    private static String[] splitCarNames(String totalCarNames) {
        String[] carNames = totalCarNames.split(",");
        for (String carName : carNames) {
            validateCarName(carName);
        }
        return carNames;
    }

    private static void validateCarName(String carName) {
        if (carName != null && carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private static int racing(RacingCar[] racingCars) {
        int result = 0;
        for (RacingCar racingCar : racingCars) {
            racingCar.race();
            result++;
        }
        return result;
    }
}

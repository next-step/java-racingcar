package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingRandom;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RacingCarView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static RacingRandom racingRandom = new RacingRandom();
    private static int cycle = 0;

    public static String inputCarInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = SCANNER.next();
        return input;
    }

    public static void inputCycle() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        cycle = SCANNER.nextInt();
    }

    public static void showResult(Cars cars) {
        System.out.println("실행결과");
        for (int i = 0; i < cycle; i++) {
            cycleCarInformation(cars.getCars());
        }
    }

    private static void cycleCarInformation(List<Car> carInfo) {
        for (int i = 0; i < carInfo.size(); i++) {
            carInfo.get(i).move(racingRandom.isMove());

            System.out.print(carInfo.get(i).getName() + " : ");
            showCarLocationInfo(carInfo.get(i).getLocation());
            System.out.println("");
        }
    }

    private static void showCarLocationInfo(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
    }

    public static void showWinner(List<Car> winnerNames) {
        System.out.print("최종 우승자 : ");
        winnerNames.stream().filter(Objects::nonNull).forEach(winner -> System.out.print(winner.getName()));
    }
}

package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RacingCarView {

    private static final Scanner scan = new Scanner(System.in);
    private static int cycle = 0;

    public static String inputCarInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scan.next();
        return input;
    }

    public static void inputCycle() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        cycle = scan.nextInt();
    }

    public static void showResult(Car car) {
        System.out.println("실행결과");
        for (int i = 0; i < cycle; i++) {
            cycleCarInformation(car.getCars());
        }
    }

    private static void cycleCarInformation(List<Cars> carsInfo) {
        for (int i = 0; i < carsInfo.size(); i++) {
            carsInfo.get(i).move();

            System.out.print(carsInfo.get(i).getName() + " : ");
            showCarLocationInfo(carsInfo.get(i).getLocationInfo());
            System.out.println("");
        }
    }

    private static void showCarLocationInfo(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
    }

    public static void showWinner(List<Cars> winnerNames) {
        System.out.print("최종 우승자 : ");
        winnerNames.stream().filter(Objects::nonNull).forEach(winner -> System.out.print(winner.getName()));
    }
}

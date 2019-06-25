package homework.week1.racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingCarGameFront {

    private static final String INPUT_CAR_NAME_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_RACING_NUMBER_GUIDE = "시도할 회수는 몇회인가요?";
    private static final String WINNER_CAR_NAME_GUIDE = "가 최종 우승했습니다.";
    private static final String RUN_SYMBOL = "-";

    String inputCarName() {
        printGuideStr(INPUT_CAR_NAME_GUIDE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    int getInputNumberOfRacing() {
        printGuideStr(INPUT_RACING_NUMBER_GUIDE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    void printGuideStr(String guideStr) {
        System.out.println(guideStr);
    }

    void printRacingCars(List<Car> cars) {
        for (Car car : cars) {
            printRacingCar(car.getName(), car.getPosition());
        }
    }

    void printRacingCar(String carName, int position) {
        String runCountStr = "";
        for (int index = 0 ; index < position; index++) {
            runCountStr += RUN_SYMBOL;
        }
        System.out.println(carName + " : " + runCountStr);
    }

    void printWinnerCars(List<String> carNames) {
        System.out.println(String.join(", ", carNames) + WINNER_CAR_NAME_GUIDE);
    }

    void printEmptyLine() {
        System.out.println();
    }

}

package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String carNames = inputView.nextLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int racingCount = inputView.next("시도할 횟수는 몇 회 인가요?");

        RacingCar racingCar = RacingCar.create(carNames, racingCount);
        ResultView.println("실행결과");
        int index = 0;
        while (!racingCar.isRacingCount(index)) {
            printRaceResult(racingCar.race());
            index++;
        }
        ResultView.printWinners(racingCar.findWinners());

        inputView.close();
    }

    private static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            ResultView.printCarDistanceWithName(car);
        }
        ResultView.println("");
    }
}

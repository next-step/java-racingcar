package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarRacing;

import java.util.ArrayList;
import java.util.List;

import static racingcar.domain.Winners.getWinners;
import static racingcar.view.InputView.userInput;
import static racingcar.view.ResultView.printGameResult;
import static racingcar.view.ResultView.printRoundResult;

public class MainView {

    public static void main(String[] args) throws Exception {
        String inputNames = userInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int times = Integer.parseInt(userInput("시도할 회수는 몇 회 인가요?"));

        CarRacing carRacing = new CarRacing(times, inputNames);

        System.out.println("실행 결과");

        List<Car> resultCars = new ArrayList<>();

        for (int i = 0; i < times; i++) {
            resultCars = carRacing.run();
            printRoundResult(resultCars);
        }

        printGameResult(getWinners(resultCars));
    }

}

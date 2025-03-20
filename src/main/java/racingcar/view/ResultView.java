package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.Position;
import racingcar.util.Pair;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printCars(Cars cars) {
        List<Pair<Name, Position>> carsNameAndPosition = cars.getCarsNameAndPosition();
        for (Pair<Name, Position> carNameAndPosition : carsNameAndPosition) {
            String carName = carNameAndPosition.getFirst().getValue();
            int carPosition = carNameAndPosition.getSecond().getValue();
            System.out.print(carName + " : " + "-".repeat(carPosition));
        }
    }

    public void printWinners(Cars winnerCars) {
        List<Name> winnerCarNameList = winnerCars.getWinnerCarNames();
        String winnerCarNames = winnerCarNameList.stream()
                .map(Name::getValue)
                .collect(Collectors.joining(", "));
        System.out.println(winnerCarNames + "가 최종 우승했습니다.");
    }
}

package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.Position;

import java.util.List;
import java.util.Map;

public class OutputView {

    private OutputView() {
        throw new UnsupportedOperationException();
    }

    public static void printRaceStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCurrentPositions(Cars cars) {
        Map<CarName, Position> currentPositions = cars.getCurrentPositions();
        currentPositions.forEach(OutputView::printCurrentPosition);
        System.out.println();
    }

    private static void printCurrentPosition(CarName carName, Position position) {
        System.out.print(carName.getName() + " : ");
        for (int i = 0; i < position.getSteps(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        for (Car winner : winners) {
            CarName carName = winner.getName();
            String name = carName.getName();
            sb.append(name + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb + " 이(가) 최종 우승했습니다");
    }
}

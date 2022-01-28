package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private static final String WINNER_MESSAGE = "최종 우승자: ";

    public void printResult(List<Car> cars) {
        for (Car car:cars){
            System.out.println(car.getCarName() + ": " + car.getPosition());
        }

    }

    public void printWinner(List<String> winnerList) {
        System.out.print(WINNER_MESSAGE);
        System.out.print(String.join(",", winnerList));
    }
}

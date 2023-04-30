package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Racing;

import java.util.List;

public class ResultView {

    private static final String SPLITTER = " : ";
    private static final String DASH = "-";
    private static final String NOTICE_WINNER = "가 최종 우승했습니다.";

    public void openResults(Racing racing) {
        List<Car> cars = racing.getRacingCars();
        for (Car car : cars) {
            CarName carName = car.getCarName();
            openIndividualResult(car, carName);
        }
        System.out.println();
    }

    public void noticeWinner(String winner) {
        System.out.print(winner + NOTICE_WINNER);
    }

    private static void openIndividualResult(Car car, CarName carName) {
        System.out.print(carName.getStringCarName() + SPLITTER);
        for (int i = 0; i < car.getMoveCount(); i++) {
            System.out.print(DASH);
        }
        System.out.println();
    }
}
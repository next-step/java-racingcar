package step2.view;

import step2.model.Car;
import step2.model.RacingWinner;

import java.util.List;

public class OutputView {

    public static void racingResult(List<Car> cars) {
        cars.forEach((car) -> carResult(car.lastCarPosition(), car.name()));
        System.out.println();
    }

    public static void carResult(int carMoveStatusNumber, String carNmae) {
        StringBuffer carMoveBuffer = new StringBuffer();
        carMoveBuffer.append(carNmae + " : ");
        while (carMoveStatusNumber > 0) {
            carMoveBuffer.append("-");
            carMoveStatusNumber--;
        }
        System.out.println(carMoveBuffer);
    }

    public static void racingWinnerResult(List<Car> cars){
        RacingWinner racingWinner = new RacingWinner(cars);
        String winners = racingWinner.maxPostionCarName();
        System.out.println(winners + "가 최종 우승 했습니다.");
    }

}
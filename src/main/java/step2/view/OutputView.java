package step2.view;

import step2.model.Car;
import step2.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void racingResult(Cars cars) {
        for(Car car : cars.getCars()){
            carResult(car.lastCarPosition(), car.name());
        }
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

    public static void racingWinnerResult(Cars cars){
        List<Car> winners = cars.maxPostionCarName();
        String winnerNames = winners.stream()
                                    .map(Car::name)
                                    .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승 했습니다.");
    }

}
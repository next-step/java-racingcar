package car;

import car.domain.Car;
import car.domain.RacingResult;
import car.domain.impl.RandomMoveStrategy;
import car.view.InputView;
import car.view.ResultView;

import java.util.*;

public class Racing {
    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();


    public static void main(String[] args) {

        List<Car> cars = carAttendList(inputView.carAttendNameSeparation(inputView.inputStringValue()));

        racingResult(cars, inputView.inputIntegerValue());
        resultView.winnerView(resultView.winnerPrint(new RacingResult(cars).getWinnerCarsName()));
    }

    private static void racingResult(List<Car> cars, int frequency) {
        for (int i = 0; i < frequency; i++) {
            System.out.println("++++++++++++++");
            carMovingState(cars);
        }
    }

    public static void carMovingState(List<Car> cars){
        for (Car car : cars){
            car.move(new RandomMoveStrategy());
            resultView.resultView(car.getName(), car.getPosition());
        }
    }
    public static List<Car> carAttendList(String[] names){
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
        return cars;
    }


}

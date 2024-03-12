package carRacing;

import car.Car;
import carRacing.view.InputView;
import carRacing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Racing {


    private int CAR_COUNT;
    private int CAR_MOVE_COUNT;
    private List<Car> cars;

    public Racing(InputView inputView) {

        //차량 수 세팅
        CAR_COUNT = inputView.getCarCount();
        //차량 이동 횟수 세팅
        CAR_MOVE_COUNT = inputView.getMoveCount();

        setCars();
    }

    public void startRacingCar() {
        for (int i = 0; i < CAR_MOVE_COUNT; i++) {
            moveCars();
            ResultView resultView = new ResultView(cars);
            resultView.show();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(1);
        }
    }

    private void setCars() {
        cars = new ArrayList<>();
        for (int carIndex = 0; carIndex < CAR_COUNT; carIndex++) {
            cars.add(new Car());
        }
    }


}

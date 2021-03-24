package carRacing;

import carRacing.model.Car;
import carRacing.model.Cars;
import carRacing.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private Cars cars;
    private OutputView outputView;

    public CarRacing(String carNames) {
        this.cars = new Cars(new ArrayList<>());
        outputView = new OutputView();
        cars.enrollCars(carNames);
    }


    public void startRacing(int racingCount) {
        checkIntParam(racingCount);
        outputView.printRacingResultTitle();
        for (int cycle = 0; cycle < racingCount; cycle++) {
            cars.excuteCycle();
            outputView.printRacingResultExcutedCycle(cars, cycle);
        }
        outputView.printRacingWinner(cars.getWinners());
    }

    private void checkIntParam(int param) {
        if (param <= 0)
            throw new IllegalArgumentException("유효한 양의 정수를 입력하세요");
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}

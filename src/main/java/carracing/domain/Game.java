package carracing.domain;

import carracing.domain.car.Car;
import carracing.domain.car.Cars;
import carracing.domain.car.strategy.CarPowerCondition;
import carracing.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {

    private int tryCount = 0;
    private List<Car> cars = null;

    public Game(String carNames, int tryCount){
        inputValid(carNames, tryCount);
        this.tryCount = tryCount;
        this.cars = this.generateCars(carNames);
    }

    private void inputValid(String carNames, int tryCount) {
        if( carNames.trim().isEmpty() || tryCount == 0) {
            throw new IllegalArgumentException("입력값을 확인해주세요.");
        }
    }

    private List<Car> generateCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] carName = carNames.split(",");

        for (int i = 0; i < carName.length; i++) {
            Car car = new Car(carName[i]);
            cars.add(car);
        }
        return cars;
    }

    /* 시도횟수 만큼 반복 */
    public List<Cars> start() throws CloneNotSupportedException {
        List<Cars> racingResult = new ArrayList<>();
        for(int i = 0; i < this.tryCount; i++) {
            Cars carList = play();
            racingResult.add(carList);
        }
        return racingResult;
    }

    /* 차의 대수 만큼 반복 */
    private Cars play() throws CloneNotSupportedException {
        List<Car> newCarList = new ArrayList<>();
        for(Car car : cars) {
            car.setPosition(new CarPowerCondition());
            Car newCar = (Car)car.clone();
            newCarList.add(newCar);
        }

        Cars carList = new Cars(newCarList);
        return carList;
    }

    public List<Car> getCars() {
        return cars;
    }
}
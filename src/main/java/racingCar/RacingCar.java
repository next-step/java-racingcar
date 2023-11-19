package racingCar;

import racingCar.domain.Car;
import racingCar.domain.Cars;
import racingCar.domain.RandomNumber;
import racingCar.view.InputView;
import racingCar.view.ResultView;

import java.util.List;

public class RacingCar {
    public static final int RANDOM_LIMIT_VALUE = 10;

    public static void main(String[] args) {
        int[] inputValues = InputView.input();
        int carNum = inputValues[0];
        int tryNum = inputValues[1];

        Cars cars = new Cars(carNum);
        movingResult(cars, tryNum);

    }

    public static Cars movingResult(Cars cars, int tryNum){
        for(int i=0; i< tryNum; i++){
            addCarMoving(cars.getCarList());
            ResultView.printNewLine();
        }

        return cars;
    }

    public static List<Car> addCarMoving(List<Car> carList){

        for(Car car : carList){
            car.moveCar(RandomNumber.getRandom(RANDOM_LIMIT_VALUE));
            ResultView.printCar(car);
        }

        return carList;
    }


    public static Cars movingNamedCarResult(Cars cars, int tryNum){
        for(int i=0; i< tryNum; i++){
            addNamedCarMoving(cars.getCarList());
            ResultView.printNewLine();
        }

        return cars;
    }

    public static List<Car> addNamedCarMoving(List<Car> carList){

        for(Car car : carList){
            car.moveCar(RandomNumber.getRandom(RANDOM_LIMIT_VALUE));
            ResultView.printNamedCar(car);
        }

        return carList;
    }

}

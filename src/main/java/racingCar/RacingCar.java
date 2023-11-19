package racingCar;

import racingCar.domain.Car;
import racingCar.domain.Cars;
import racingCar.domain.RandomNumber;
import racingCar.view.ResultView;
import racingCar.view.WinnerResultView;

import java.util.List;

public class RacingCar {
    public static final int RANDOM_LIMIT_VALUE = 10;

    public static Cars movingResult(Cars cars, int tryNum){
        for(int i=0; i< tryNum; i++){
            addCarMoving(cars.getCarList());
        }

        return cars;
    }

    public static List<Car> addCarMoving(List<Car> carList){

        for(Car car : carList){
            car.moveCar(RandomNumber.getRandom(RANDOM_LIMIT_VALUE));
        }
        ResultView.printCar(carList);

        return carList;
    }


    public static Cars movingNamedCarResult(Cars cars, int tryNum){
        for(int i=0; i< tryNum; i++){
            addNamedCarMoving(cars.getCarList());
        }

        return cars;
    }

    public static List<Car> addNamedCarMoving(List<Car> carList){

        for(Car car : carList){
            car.moveCar(RandomNumber.getRandom(RANDOM_LIMIT_VALUE));
        }
        WinnerResultView.printNamedCar(carList);

        return carList;
    }

    public static List<String> returnWinner(Cars cars){
        List<String> winners = cars.returnWinnerCars();

        WinnerResultView.printWinner(winners);

        return winners;
    }

}

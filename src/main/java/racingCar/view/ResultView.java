package racingCar.view;

import racingCar.RacingCar;
import racingCar.domain.Car;
import racingCar.domain.Cars;

import java.util.List;

public class ResultView {

    public static void main(String[] args) {
        int[] inputValues = InputView.input();
        int carNum = inputValues[0];
        int tryNum = inputValues[1];

        Cars cars = new Cars(carNum);
        RacingCar.movingResult(cars, tryNum);

    }

    public static void printEachCar(Car car){
        for(int i=0; i < car.getForwardCount(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printCar(List<Car> carList){
        for(Car car : carList) {
            printEachCar(car);
        }
        System.out.println();
    }

}

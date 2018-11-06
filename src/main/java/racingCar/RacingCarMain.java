package racingCar;

import java.util.List;

import static racingCar.Car.moveCar;
import static racingCar.RacingCarUtil.arrayToList;
import static racingCar.RacingCarUtil.splitList;
import static racingCar.RacingCarInit.*;
import static racingCar.RacingCarUI.*;


public class RacingCarMain {
    private static int time;
    private static Car[] cars;
    private static List<Car> carList;


    public static void main(String[] args){
        String carListStr = inputCarName();
        cars = initCar(splitList(carListStr));
        time = inputTryCount();

        System.out.println("실행 결과");

        for(int i=0; i<time;i++){
            cars = moveCar(cars);
            outputResult(cars);
        }
        carList = arrayToList(cars);
        outputWinners(carList);

    }
}

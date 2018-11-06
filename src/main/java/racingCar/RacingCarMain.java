package racingCar;

import java.util.Scanner;

import static racingCar.RacingCar.*;
import static racingCar.RacingCarUI.*;


public class RacingCarMain {
    private static int time;
    private static CarVO[] cars;


    public static void main(String[] args){
        String carList = inCarName();
        cars = createCarVO(splitCarList(carList));
        time = inTryCount();

        System.out.println("실행 결과");
        for(int i=0; i<time;i++){
            cars = moveCar(cars);
            outResult(cars);
        }
        outWinners(cars);

    }
}

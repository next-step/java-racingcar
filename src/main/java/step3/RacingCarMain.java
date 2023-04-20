package step3;


import java.util.List;

import static step3.RacingCar.*;
import static step3.input.InputView.input;
import static step3.output.ResultView.printRace;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingCar rc = new RacingCar();
        int car = input("자동차 대수는 몇 대 인가요?");
        int count = input("시도할 회수는 몇 회 인가요?");

        List<Car> cars = initCars(car);
        for(int i=0; i<count; i++){
            rc.oneRace(cars);
            printRace(cars);
        }
    }
}

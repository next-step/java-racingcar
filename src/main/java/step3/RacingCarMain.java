package step3;

import java.util.List;

import static step3.Car.*;
import static step3.RacingCar.*;
import static step3.input.InputView.input;
import static step3.output.ResultView.printRace;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingCar rc = new RacingCar();
        int carCount = input("자동차 대수는 몇 대 인가요?");
        int raceCount = input("시도할 회수는 몇 회 인가요?");

        List<Car> cars = createCars(carCount);
        for(int i=0; i<raceCount; i++){
            rc.oneRace(cars);
            printRace(cars);
        }
    }
}

package step4.view;

import step4.action.Race;
import step4.model.Car;

import java.util.List;

public class ResultView {
    public static void startRaceStep3(int carCounts, int raceTimes) {
        Race race = Race.of(carCounts);
        Print.print("실행 결과");
        for(int i=0; i<raceTimes; i++){
            Print.print(race.getCars());
            race.doRace();
            System.out.println();
        }
    }

    public static void printResult(List<Car> cars) {
        Print.print("실행 결과");
        Print.printWinner(cars);
    }

    public static void printCars(List<Car> cars) {
        Print.print(cars);
    }
}

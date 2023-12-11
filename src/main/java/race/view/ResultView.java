package race.view;

import race.domain.Car;
import race.domain.Cars;
import race.domain.Winners;

public class ResultView {

    public static void printResult(Winners winners){
        System.out.println("실행 결과");
        ResultView.printWinners(winners);
    }

    public static void printCarPosition(Cars cars) {
        for(Car car: cars.cars()){
            System.out.println(car.name() + " : " + "-".repeat(car.position()));
        }
        System.out.println();
    }

    private static void printWinners(Winners winners) {
        System.out.println("최종 우승 : " + winners.getWinners());
    }
}

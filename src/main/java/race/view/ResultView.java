package race.view;

import race.domain.Car;
import race.domain.Cars;
import race.domain.Winners;

public class ResultView {

    public static void printResult(Cars cars){
        System.out.println("실행 결과");

        Winners winners = new Winners(cars);

        ResultView.printWinners(winners);
    }

    public static void printCarPosition(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public static void printWinners(Winners winners) {
        System.out.println("최종 우승 : " + winners.getWinners());
    }
}

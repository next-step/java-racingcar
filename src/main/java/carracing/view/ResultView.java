package carracing.view;

import carracing.domain.Car;
import carracing.domain.Race;

public class ResultView {

    public void showCarsInitState(Race race) {
        System.out.println("\n실행 결과");
        showCarsState(race);
    }

    public void showCarsState(Race race) {
        for (Car car : race.getCars()) {
            System.out.printf("%5s %s%n", car.getName(), "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void showWinnerNames(Race race) {
        System.out.printf("%s가 최종 우승했습니다.", String.join(", ", race.getWinners()));
    }
}

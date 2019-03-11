package racingcar.racingcar_refactoring_version2;

import java.util.ArrayList;
import java.util.List;

public class WinnerUtils {

    private List<Car> cars;
    private int highScore = 0;
    private ArrayList<String> winners;
    private Race race;

    public WinnerUtils(Race race) {
        this.race = race;
    }


    public void topRankSearchAndPrint() {
        cars = race.getCars();
        getHighScore();
        winners = new ArrayList<>();
        for (Car car : cars) {
            getWinners(car);
        }
        System.out.println("\n\n" + String.join(",", winners) + "가 우승자 입니다.");
    }

    public void getHighScore() {
        for (Car car : cars) {
            replaceHighScore(car);
        }
    }

    private void replaceHighScore(Car car) {
        if (car.getMovingDistance() > highScore) {
            highScore = car.getMovingDistance();
        }
    }

    private void getWinners(Car car) {
        if (car.getMovingDistance() == highScore) {
            winners.add(car.getName());
        }
    }

}

package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private Race race;
    private int moveCount;
    private int maxScore = 0;
    private List<String> winners;

    public RacingGame(String carNames, int moveCount) {
        this.moveCount = moveCount;
        this.race = new Race(carNames);
    }

    public void startRace() {
        for (int i = 0; i < moveCount; i++) {
            System.out.println((i + 1) + "번째횟수");
            race.run();
            printCarsDistance();
        }
        getMaxScore();
        topRankSearch();
    }


    private void getMaxScore() {
        for (Car car : race.getCars()) {
            replaceMaxScore(car);
        }
    }

    private void replaceMaxScore(Car car) {
        if (car.getMovingDistance() > maxScore) {
            maxScore = car.getMovingDistance();
        }
    }

    private void topRankSearch() {
        winners = new ArrayList<>();
        for (Car car : race.getCars()) {
            getWinnders(car);
        }
        System.out.println("\n\n" + String.join(",", winners) + "가 우승자 입니다.");
    }

    private void getWinnders(Car car) {
        if (car.getMovingDistance() == maxScore) {
            winners.add(car.getName());
        }
    }

    private void printCarsDistance() {
        for (Car car : race.getCars()) {
            printCarDistance(car);
        }
    }

    private void printCarDistance(Car car) {
        StringBuilder raceResult = new StringBuilder(car.getName() + " : ");
        for (int i = 0; i < car.getMovingDistance(); i++) {
            raceResult.append("-");
        }
        System.out.println(raceResult.toString());
    }


}


package racecar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RacingGame {

    public List<Car> ready(String[] carName) {
        List<Car> carList = new ArrayList<>();
        for (String name : carName) {
            carList.add(Car.generate(name));
        }
        return carList;
    }

    public void start(List<Car> carList) {
        Random random = new Random();
        for (Car car : carList) {
            car.move(random);
        }
    }

    public List<String> announceWinner(List<Car> carList) {
        int winScore = getWinScore(carList);
        List<String> winners = selectWinner(carList, winScore);
        return winners;
    }

    private int getWinScore(List<Car> carList) {
        List<Integer> scores = new ArrayList<>();
        for (Car car : carList)
            scores.add(car.getPosition());
        int winScore = Collections.max(scores);
        return winScore;
    }

    private List<String> selectWinner(List<Car> carList, int winScore) {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (winScore == car.getPosition())
                winners.add(car.getName());
        }
        return winners;
    }
}

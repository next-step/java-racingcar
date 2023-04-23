package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class RacingService {

    public void moveByNumOfTriesAndShowResult(Racing racing) {
        ResultView resultView = new ResultView();
        for (int i = 0; i < racing.getNumOfTries(); i++) {
            move(racing);
            resultView.showCurrentState(racing.getCars());
        }
        printWinners(racing);
    }

    private void printWinners(Racing racing) {
        Set<String> winners = selectWinner(racing);
        StringJoiner joiner = new StringJoiner(",");
        winners.forEach(joiner::add);
        System.out.println(winners.toString() + "가 최종 우승했습니다.");
    }

    public void move(Racing racing) {
        ArrayList<Car> newCars = (ArrayList<Car>) racing.getCars().stream()
                .map(car -> {
                    int rand = generateRand();
                    return rand > racing.getThreshold() ? car.moveFoward(rand) : car;
                }).collect(Collectors.toList());
        racing.setCars(newCars);
    }

    private int generateRand() {
        return new Random().nextInt(10);
    }

    public Set<String> selectWinner(Racing racing) {
        Set<String> winners = new HashSet<>();
        int max = 0;
        for (Car car : racing.getCars()) {
            if (car.getCurrentDistance() > max) {
                winners.clear();
                winners.add(car.getName());
                max = car.getCurrentDistance();
            }
            if (car.getCurrentDistance() == max) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}

package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class RacingService {

    public void moveByNumOfTriesAndShowResult(Racing racing) {
        ResultView resultView = new ResultView();
        for (int i = 0; i < racing.numOfTries(); i++) {
            move(racing);
            resultView.showCurrentState(racing.cars());
        }
        printWinners(racing);
    }

    private void printWinners(Racing racing) {
        Set<String> winners = selectWinner(racing);
        StringJoiner joiner = new StringJoiner(",");
        winners.forEach(joiner::add);
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    public void move(Racing racing) {
        ArrayList<Car> newCars = (ArrayList<Car>) racing.cars().stream()
                .map(car -> {
                    int rand = generateRand();
                    return rand > racing.threshold() ? car.moveFoward(rand) : car;
                }).collect(Collectors.toList());
        racing.setCars(newCars);
    }

    private int generateRand() {
        return new Random().nextInt(10);
    }

    public Set<String> selectWinner(Racing racing) {
        Set<String> winners = new HashSet<>();
        int max = 0;
        for (Car car : racing.cars()) {
            if (car.isFurtherThan(max)) {
                resetWinner(winners, car);
                max = car.currentDistance();
            }
            if (car.isSameDistance(max)) {
                addWinner(winners, car);
            }
        }
        return winners;
    }

    private void addWinner(Set<String> winners, Car car) {
        winners.add(car.name());
    }

    private void resetWinner(Set<String> winners, Car car) {
        winners.clear();
        winners.add(car.name());
    }
}

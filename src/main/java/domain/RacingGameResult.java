package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingGameResult {
    List<Car> ranking = new ArrayList<>();
    List<RoundResult> roundResults = new ArrayList<>();

    public void createRanking(List<Car> cars){
        cars.stream()
            .sorted(Comparator.comparing(Car::getMileage).reversed())
            .forEach(ranking::add);
    }

    public void addRoundResult(RoundResult roundResult){
        roundResults.add(roundResult);
    }

    public List<Car> getRanking() {
        return ranking;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }
}

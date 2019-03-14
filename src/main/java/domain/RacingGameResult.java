package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.Getter;

public class RacingGameResult {
    @Getter
    List<Car> ranking = new ArrayList<>();

    @Getter
    List<RoundResult> roundResults = new ArrayList<>();

    public void createRanking(List<Car> cars){
        cars.stream()
            .sorted(Comparator.comparing(Car::getMileage).reversed())
            .forEach(ranking::add);
    }

    public void addRoundResult(RoundResult roundResult){
        roundResults.add(roundResult);
    }
}

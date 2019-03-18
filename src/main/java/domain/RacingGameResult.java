package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.Getter;

public class RacingGameResult {
    @Getter
    List<Car> winner = new ArrayList<>();

    @Getter
    List<RoundResult> roundResults = new ArrayList<>();

    public void createWinner(List<Car> cars){
        int max = cars.stream().mapToInt(Car::getMileage).max().getAsInt();

        cars.stream()
            .filter(c -> c.getMileage().equals(max))
            .forEach(winner::add);
    }

    public void addRoundResult(RoundResult roundResult){
        roundResults.add(roundResult);
    }
}

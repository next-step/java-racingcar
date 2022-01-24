package racing;

import java.util.ArrayList;
import java.util.List;

public class Judgement {

    private final List<Car> cars;
    private final int bestScore;

    public Judgement(List<Car> cars) {
        this.cars = cars;
        this.bestScore = getBestScore();
    }

    private int getBestScore() {
        cars.sort((a, b) -> b.getDistance() - a.getDistance());
        return cars.get(0).getDistance();
    }

    public List<String> judgeWinner() {
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            if (i == 0 || cars.get(i).getDistance() == bestScore) {
                winners.add(cars.get(i).getName());
            }
        }

        return winners;
    }
}

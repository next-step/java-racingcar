package racinggame.view;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racinggame.domain.RacingCar;
import racinggame.domain.Utils;

public class GameView {

    private static final String DELIMITER = ", ";

    private List<RacingCar> racingCars;

    private GameView() {}

    public GameView(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void printProgress() {
        StringBuilder sb = new StringBuilder();
        racingCars.forEach(car -> sb.append(car.drawCurrPosition()));

        System.out.println(sb);
    }

    private List<Integer> getCarPositions() {
        return racingCars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList());
    }

    public void printWinners() {
        int max = getHighScore();
        List<String> winners = getWinners(max);

        String result = winners.stream().collect(Collectors.joining(DELIMITER));
        System.out.println("최종 우승자: " + result);
    }

    private int getHighScore() {
        return Collections.max(getCarPositions());
    }



    private List<String> getWinners(int max) {
        return racingCars.stream()
                .filter(car -> car.getPosition() == max)
                .map(car -> car.getCarName())
                .collect(Collectors.toList());
    }
}

package racinggame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class View {

    private static final String DELIMITER = ", ";

    private List<RacingCar> racingCars;

    private View() {}

    public View(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void printProgress() {
        StringBuilder sb = new StringBuilder();
        racingCars.forEach(car -> sb.append(drawCurrPosition(car)));

        System.out.println(sb);
    }

    private String drawCurrPosition(RacingCar car) {
        String trace = Utils.repeat("-", car.getPosition());
        return String.format("%-5s: %s\n", car.getCarName(), trace);
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

    private List<Integer> getCarPositions() {
        return racingCars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList());
    }

    private List<String> getWinners(int max) {
        return racingCars.stream()
                .filter(car -> car.getPosition() == max)
                .map(car -> car.getCarName())
                .collect(Collectors.toList());
    }
}

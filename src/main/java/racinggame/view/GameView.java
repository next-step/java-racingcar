package racinggame.view;

import java.util.List;
import java.util.stream.Collectors;
import racinggame.domain.Judge;
import racinggame.domain.RacingCar;

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

    public void printWinners() {
        List<String> winners = Judge.getWinners(racingCars);

        String result = winners.stream().collect(Collectors.joining(DELIMITER));
        System.out.println("최종 우승자: " + result);
    }
}

package racinggame.view;

import java.util.List;
import racinggame.domain.RacingCar;

public class GameView {

    private static final String DELIMITER = ", ";
    protected final StringBuilder result = new StringBuilder();

    private List<CarResultView> carResultViews;

    public GameView(List<RacingCar> racingCars) {
        carResultViews = CarResultView.racingCarOf(racingCars);
    }

    public void saveProgress() {
        carResultViews.forEach(carView -> result.append(carView.drawCurrResult()).append("\n"));
    }

    public void printWinners(List<String> winners) {
        String result = String.join(DELIMITER, winners);
        System.out.println("최종 우승자: " + result);
    }

    public void printResult() {
        System.out.print(result);
    }
}

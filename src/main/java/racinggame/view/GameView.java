package racinggame.view;

import java.util.List;
import racinggame.domain.RacingCars;

public class GameView {

    private static final String DELIMITER = ", ";
    protected final StringBuilder result = new StringBuilder();

    private final List<CarResultView> carResultViews;

    public GameView(final RacingCars racingCars) {
        carResultViews = CarResultView.racingCarOf(racingCars);
    }

    public void saveProgress() {
        carResultViews.forEach(carView -> result.append(carView.drawCurrResult()).append("\n"));
    }

    public void printWinners(final List<String> winners) {
        final String result = String.join(DELIMITER, winners);
        System.out.println("최종 우승자: " + result);
    }

    public void printResult() {
        System.out.print(result);
    }
}

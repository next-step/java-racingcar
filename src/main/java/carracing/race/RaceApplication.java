package carracing.race;

import carracing.race.ui.InputView;
import carracing.race.ui.ResultView;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class RaceApplication {
    private static final Random random = new Random();

    private final InputView inputView;
    private final ResultView resultView;
    public RaceApplication(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        int participate = inputView.participate();
        int iterations = inputView.iterations();
        this.racingStart(participate,iterations);

    }

    public Map<Integer, List<Integer>> racingStart(int participate, int iterations) {
        return null;
    }

    public int getRandom() {
        return random.nextInt(9);
    }

    //public
}

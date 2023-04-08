package carracing.race;

import carracing.race.logic.AutomobileFederation;
import carracing.race.ui.InputView;
import carracing.race.ui.ResultView;

import java.util.ArrayList;
import java.util.HashMap;
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
        Map<Integer, List<Integer>> raceResults = this.racingStart(participate, iterations);
        resultView.printResult(new AutomobileFederation(raceResults));

    }

    public Map<Integer, List<Integer>> racingStart(int participate, int iterations) {

        Map<Integer, List<Integer>> resultMap = new HashMap<>();

        for (int stage = 1; stage <= iterations; stage++) {
            //todo : 로직이 이중포문에 더티하게 섞여있어서 매우 복잡하다 리팩토링 필요
            List<Integer> raceRecode = new ArrayList<>();
            for (int i = 0; i < participate; i++) {

                raceRecode.add(getRandom());
            }
            resultMap.put(stage, raceRecode);
        }
        return resultMap;
    }

    public int getRandom() {
        return random.nextInt(9);
    }

    //public
}

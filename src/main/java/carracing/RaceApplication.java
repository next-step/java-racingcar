package carracing;

import carracing.logic.AutomobileFederation;
import carracing.logic.type.Round;
import carracing.logic.type.Score;
import carracing.ui.InputView;
import carracing.ui.ResultView;

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

    public static void main(String[] args) {
        RaceApplication raceApplication = new RaceApplication(new InputView(System.in,System.out),new ResultView(System.out));
        raceApplication.run();
    }

    public void run() {
        int participate = inputView.participate();
        int iterations = inputView.iterations();
        Map<Round, List<Score>> raceResults = this.racingStart(participate, iterations);
        resultView.printResult(new AutomobileFederation(raceResults));

    }

    public Map<Round, List<Score>> racingStart(int participate, int iterations) {

        Map<Round, List<Score>> resultMap = new HashMap<>();

        for (int stage = 1; stage <= iterations; stage++) {
            //todo : 로직이 이중포문에 더티하게 섞여있어서 매우 복잡하다 리팩토링 필요
            List<Score> raceRecode = new ArrayList<>();
            for (int i = 0; i < participate; i++) {

                raceRecode.add(new Score(getRandom()));
            }
            resultMap.put(new Round(stage), raceRecode);

        }
        return resultMap;
    }

    public int getRandom() {
        return random.nextInt(9);
    }

    //public
}

package carracing;

import carracing.logic.AutomobileFederation;
import carracing.logic.type.Round;
import carracing.logic.type.Score;
import carracing.ui.InputView;
import carracing.ui.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceApplication {
    private static final Random random = new Random();

    private final InputView inputView;
    private final ResultView resultView;

    public RaceApplication(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public static void main(String[] args) {
        RaceApplication raceApplication = new RaceApplication(
                new InputView(System.in, System.out),
                new ResultView(System.out)
        );
        raceApplication.run();
    }

    public void run() {
        int participate = inputView.participate();
        int iterations = inputView.iterations();
        Map<Round, List<Score>> raceResults = this.racingStart(participate, iterations);
        resultView.printResult(new AutomobileFederation(raceResults));
    }

    public Map<Round, List<Score>> racingStart(int participate, int iterations) {
        return IntStream.rangeClosed(1,iterations)
                .boxed()
                .collect(
                        Collectors.toMap(Round::new, round -> simulateSingleRoundScores(participate))
                );
    }

    private List<Score> simulateSingleRoundScores(int participate) {
        return IntStream.generate(this::randomScore)
                .limit(participate)
                .boxed()
                .map(Score::new)
                .collect(Collectors.toList());
    }

    public int randomScore() {
        return random.nextInt(9);
    }
}

package carracing;

import carracing.repository.RoundRepository;
import carracing.service.RacingService;
import carracing.domain.Round;
import carracing.domain.Score;
import carracing.ui.InputView;
import carracing.ui.ResultView;
import carracing.ui.impl.ResultViewV0;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceApplication {
    private static final Random random = new Random();

    private final InputView inputView;
    private final ResultView resultView;
    //private final RoundRepository roundRepository;
    private final RacingService racingService;

    public RaceApplication(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.racingService = new RacingService(new RoundRepository());
    }

    public static void main(String[] args) {
        RaceApplication raceApplication = new RaceApplication(
            new InputView(System.in, System.out),
            new ResultViewV0(System.out)
        );
        raceApplication.run();
    }

    public void run() {
//        resultView.printResult(
//            new RacingService(
//                this.racingStart(inputView.participates(), inputView.iterations())
//            )
//        );
    }

    public Map<Round, List<Score>> racingStart(int participate, int iterations) {
        return IntStream.rangeClosed(1, iterations)
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

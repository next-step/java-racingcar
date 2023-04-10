package carracing;

import carracing.repository.RoundRepository;
import carracing.service.RacingService;
import carracing.domain.Round;
import carracing.domain.Score;
import carracing.presentation.InputPresentation;
import carracing.presentation.ResultPresentation;
import carracing.presentation.impl.ResultPresentationV0;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceApplication {
    private static final Random random = new Random();

    private final InputPresentation inputPresentation;
    private final ResultPresentation resultPresentation;
    //private final RoundRepository roundRepository;
    private final RacingService racingService;

    public RaceApplication(InputPresentation inputPresentation, ResultPresentation resultPresentation) {
        this.inputPresentation = inputPresentation;
        this.resultPresentation = resultPresentation;
        this.racingService = new RacingService(new RoundRepository());
    }

    public static void main(String[] args) {
        RaceApplication raceApplication = new RaceApplication(
            new InputPresentation(System.in, System.out),
            new ResultPresentationV0(System.out)
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

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

    private final InputPresentation inputPresentation;
    private final ResultPresentation resultPresentation;
    private final RacingService racingService;

    public RaceApplication(InputPresentation inputPresentation, ResultPresentation resultPresentation, RacingService racingService) {
        this.inputPresentation = inputPresentation;
        this.resultPresentation = resultPresentation;
        this.racingService = racingService;
    }

    public static void main(String[] args) {
        RaceApplication raceApplication = initialize();
        raceApplication.run();
    }

    private static RaceApplication initialize() {
        RacingService racingServiceLocal = new RacingService(new RoundRepository());
        return new RaceApplication(
            new InputPresentation(System.in, System.out),
            new ResultPresentationV0(System.out, racingServiceLocal),
            racingServiceLocal
        );
    }

    public void run() {
        int participates = inputPresentation.participates();
        int iterations = inputPresentation.iterations();
        racingService.racingStart(participates, iterations);
        resultPresentation.printResult();
    }
}

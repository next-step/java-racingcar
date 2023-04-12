package carracing;

import carracing.presentation.InputPresentation;
import carracing.presentation.ResultPresentation;
import carracing.presentation.impl.ResultPresentationV0;
import carracing.repository.RoundRepository;
import carracing.service.RacingService;

import java.util.HashMap;
import java.util.Map;

public class RaceApplication {

    private static final Map<Class<?>, Object> ioc = new HashMap<>();
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
        ioc.put(RoundRepository.class, new RoundRepository());
        ioc.put(RacingService.class, new RacingService((RoundRepository) ioc.get(RoundRepository.class)));
        ioc.put(ResultPresentationV0.class, new ResultPresentationV0(System.out, (RacingService) ioc.get(RacingService.class)));
        ioc.put(InputPresentation.class, new InputPresentation(System.in, System.out));
        return new RaceApplication(
            (InputPresentation) ioc.get(InputPresentation.class),
            (ResultPresentationV0) ioc.get(ResultPresentationV0.class),
            (RacingService) ioc.get(RacingService.class)
        );
    }

    public void run() {
        racingService.racingStart(inputPresentation.participates(), inputPresentation.iterations());
        resultPresentation.printResult();
    }
}

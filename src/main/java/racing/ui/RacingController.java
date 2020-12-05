package racing.ui;

import dto.Request;
import dto.Response;
import racing.application.RacingService;
import racing.domain.GameReport;

import java.util.Objects;

public class RacingController {

    private final RacingService racingService;

    public RacingController(final RacingService racingService) {
        this.racingService = Objects.requireNonNull(racingService);
    }


    public Response play(final Request input) {
        GameReport gameReport = racingService.play(input.getCarCount(), input.getRound());
        return Response.of(gameReport);
    }
}

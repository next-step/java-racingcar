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


    public Response play(final Request request) {
        GameReport gameReport = racingService.play(request.getCarNames(), request.getRound());
        return Response.of(gameReport);
    }
}

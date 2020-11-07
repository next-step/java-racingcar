package racing;

import racing.controller.GrandPrixController;
import racing.domain.GrandPrix;
import racing.resolver.AccelerateResolver;
import racing.resolver.RandomAccelerateResolver;
import racing.service.GrandPrixService;
import racing.service.LineUpService;
import racing.service.RaceMachineService;
import racing.view.RacingInputView;
import racing.view.to.RacingInputTO;

public class RacingApplication {
    private static final GrandPrixService grandPrixService = new GrandPrixService();
    private static AccelerateResolver accelerateResolver = new RandomAccelerateResolver(10, 4);
    private static final LineUpService lineUpService = new LineUpService(new RaceMachineService(), accelerateResolver);
    private static final GrandPrixController grandPrixController = new GrandPrixController(grandPrixService, lineUpService);

    public static void main(String[] args) {
        RacingInputTO racingInputTO = RacingInputView.getRacingInput();
        GrandPrix grandPrix = grandPrixController.create(racingInputTO);
        grandPrixController.startRace(grandPrix);
    }

    public static void setAccelerateResolver(AccelerateResolver newAccelerateResolver) {
        accelerateResolver = newAccelerateResolver;
    }
}

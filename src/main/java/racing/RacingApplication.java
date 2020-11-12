package racing;

import racing.controller.GrandPrixController;
import racing.domain.GrandPrix;
import racing.resolver.AccelerateResolver;
import racing.resolver.RandomAccelerateResolver;
import racing.service.GrandPrixService;
import racing.service.LineUpService;
import racing.service.RaceMachineService;

public class RacingApplication {
    private static final GrandPrixService grandPrixService = new GrandPrixService();
    private static final AccelerateResolver accelerateResolver = new RandomAccelerateResolver(10, 4);
    private static final LineUpService lineUpService = new LineUpService(new RaceMachineService(), accelerateResolver);
    private static final GrandPrixController grandPrixController = new GrandPrixController(grandPrixService, lineUpService);

    public static void main(String[] args) {
        GrandPrix grandPrix = grandPrixController.create();
        grandPrixController.startRace(grandPrix);
    }
}

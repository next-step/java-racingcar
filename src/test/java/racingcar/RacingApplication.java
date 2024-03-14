package racingcar;

import racingcar.controller.RacingController;

import racingcar.repository.RacingRepository;
import racingcar.service.RacingService;


public class RacingApplication {
    public static void main(String[] args) {
        RacingRepository repository = new RacingRepository();
        RacingService racingService = new RacingService(repository);
        new RacingController(racingService);
    }
}

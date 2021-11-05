package carracing.service;

import carracing.CarRacing;
import carracing.RacingUtils;
import java.security.SecureRandom;

public class CarRacingService {

    private SecureRandom random = new SecureRandom();

    private CarRacing carRacing;

    public CarRacingService(CarRacing carRacing) {
        this.carRacing = carRacing;
    }

    public CarRacing gameStart() {
        final Integer CARS_LENGTH = carRacing.getCarsSize();
        for (int i = 0; i < CARS_LENGTH; i++) {
            this.run(carRacing, i);
        }
        return carRacing;
    }

    private void run(CarRacing carRacing, int i) {
        if (this.isRun()) {
            carRacing.run(i);
        }
    }

    private Boolean isRun() {
        return random.nextInt(RacingUtils.MAX_RANDOM) >= 4;
    }

}

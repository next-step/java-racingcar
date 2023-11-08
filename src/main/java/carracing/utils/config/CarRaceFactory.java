package carracing.utils.config;

import carracing.CarRaceService;

public class CarRaceFactory {
    public static CarRaceService carRaceService;

    public static void init() {
        carRaceService = CarRaceConfig.carRaceService();
    }
}

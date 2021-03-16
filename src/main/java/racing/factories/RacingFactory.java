package racing.factories;

import racing.models.Racing;

public class RacingFactory {
    public static Racing createFrom(String[] carNames) {
        return new Racing(CarsFactory.createFrom(carNames), RoundsFactory.createFrom());
    }
}

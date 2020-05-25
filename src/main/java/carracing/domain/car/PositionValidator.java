package carracing.domain.car;

import carracing.domain.car.Position;

public class PositionValidator {
    public static void validate(Position position) {
        if(position.validate()) {
            throw new IllegalStateException("Car position should be more than 0");
        }
    }
}

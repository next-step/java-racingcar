package carracing;

import carracing.domain.Position;

public class PositionValidator {
    public static void validate(Position position) {
        if(position.validate()) {
            throw new IllegalStateException("Car position should be more than 0");
        }
    }
}

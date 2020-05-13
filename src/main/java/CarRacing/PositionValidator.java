package CarRacing;

public class PositionValidator {
    public static void validate(Position position) {
        if(position.location < 0) {
            throw new IllegalStateException("Car position should be more than 0");
        }
    }
}

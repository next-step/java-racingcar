package RacingCar;

public interface Car {
    String getName();

    int getDistance();

    int forward(MovementCondition movementCondition);
}

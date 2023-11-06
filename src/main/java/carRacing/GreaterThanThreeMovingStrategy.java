package carRacing;

public class GreaterThanThreeMovingStrategy implements MovingStrategy{

    @Override
    public boolean isRide(int randomNumber) {
        return randomNumber > 3;
    }
}

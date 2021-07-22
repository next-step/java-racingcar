package racing;

public class Car {

    private int carNumber;
    private int raceDistance;

    public Car(int carNumber) {
        this.carNumber = carNumber;
        this.raceDistance = 0;
    }

    public int carRacingAct(int randomValue) {
        return randomValue > 3 ? ++raceDistance : raceDistance;
    }

}

package step3_racing_car;

public class RacingCars {
    RacingCar[] racingCars;

    public RacingCars(int participantCarCount) {

        RacingCar[] racingCars = new RacingCar[participantCarCount];
        for (int i = 0; i < participantCarCount; i++) {
            racingCars[i] = new RacingCar();
        }

        this.racingCars = racingCars;
    }

    public void movePosition(int distance) {
        for (int i = 0; i < racingCars.length; i++) {
            racingCars[i].movePositions(distance);
        }
    }
}

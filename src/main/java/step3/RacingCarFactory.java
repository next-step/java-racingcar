package step3;

public class RacingCarFactory {

    static RacingCar createRacingCarWithInputView() {

        int numberOfCar = RacingCarInputView.scanNumberOfCar();
        int numberOfRace = RacingCarInputView.scanNumberOfRace();

        return createRacingCar(numberOfCar, numberOfRace);
    }

    static RacingCar createRacingCar(int numberOfCar, int numberOfRace) {
        return new RacingCar(numberOfCar, numberOfRace);
    }
}

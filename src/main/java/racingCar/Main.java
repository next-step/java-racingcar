package racingCar;

public class Main {
    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int runCount = InputView.inputRunCount();

        CarRace carRace = new CarRace(carCount);

        for(int i = 0; i < runCount; i++) {
            carRace.play();
            ResultView.show(carRace.getCars());
        }
    }
}

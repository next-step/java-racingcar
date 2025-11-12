package racingCar;

public class Main {
    public static void main(String[] args) {
        String names = InputView.inputCarName();
        int runCount = InputView.inputRunCount();

        CarRace carRace = new CarRace(names);

        for(int i = 0; i < runCount; i++) {
            carRace.play();
            ResultView.show(carRace.getCars());
        }
    }
}

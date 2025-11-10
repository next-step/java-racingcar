package racingCar;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        int carCount = inputView.inputCarCount();
        int runCount = inputView.inputRunCount();

        ResultView resultView = new ResultView();

        CarRace carRace = new CarRace(carCount);

        for(int i=0; i<runCount; i++) {
            carRace.play();
            resultView.show(carRace.getCars());
        }
    }
}

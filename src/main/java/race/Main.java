package race;

public class Main {

    public static void main(String[] args) {

        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount() - 1;

        CarRace carRace = new CarRace(carCount, tryCount, new CarForwardCheck());

        ResultView.output(carRace.getCars());
        while (carRace.checkTryCount()) {
            carRace.proceedRound();
            ResultView.output(carRace.getCars());
        }
    }

}

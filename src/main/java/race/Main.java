package race;

public class Main {

    public static void main(String[] args) {

        String[] carNames = InputView.inputCarName();
        int tryCount = InputView.inputTryCount();

        CarRace carRace = new CarRace(carNames, tryCount, new CarForwardCheck());

        ResultView.output(carRace.getCars());
        while (carRace.checkTryCount()) {
            carRace.proceedRound();
            ResultView.output(carRace.getCars());
        }

        ResultView.announceWinner(carRace.getRaceResult());
    }
}

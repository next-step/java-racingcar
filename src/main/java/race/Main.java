package race;

public class Main {

    public static void main(String[] args) {

        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        CarRace carRace = new CarRace(carCount, tryCount, new CarRandomNumber());

        ResultView.output(carRace.getCars());
        for (int i = 0; i < carRace.getTryCount(); i++) {
            carRace.proceedRound();
            ResultView.output(carRace.getCars());
        }
    }

}

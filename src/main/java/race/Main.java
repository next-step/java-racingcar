package race;

public class Main {

    public static void main(String[] args) {

        RaceInput raceInput = InputView.input();

        CarRace carRace = new CarRace(raceInput.getCarCount(), raceInput.getTryCount(), new CarRandomNumber());

        ResultView.output(carRace.getCars());
        for (int i = 0; i < carRace.getTryCount(); i++) {
            carRace.proceedRound();
            ResultView.output(carRace.getCars());
        }
    }

}

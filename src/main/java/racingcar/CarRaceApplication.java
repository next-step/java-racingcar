package racingcar;

public class CarRaceApplication {


    public static void main(String[] args) throws Exception {
        String[] carNames = InputView.inputRaceCarNames();
        int tryCnt = InputView.inputRaceTryCount();
        CarRace carRace = new CarRace(carNames, tryCnt);

        ResultView.printResultMsg();

        carRace.race();

        ResultView.print(carRace);
        ResultView.printWinner(carRace.getWinnerCars());
    }

}

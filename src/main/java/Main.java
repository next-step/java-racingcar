public class Main {

    public static void main(String[] args) {
        CarRace carRace = new CarRace();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.askNumberOfCars();
        int cars = inputView.getInputNumber();

        inputView.askNumberOfTurns();
        int turns = inputView.getInputNumber();

        resultView.printRaceStart();
        carRace.start(cars, turns);
    }
}

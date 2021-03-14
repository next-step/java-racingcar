package step4;

public class CarRacingApplication {
    public static void main(String[] args) {
        OutputView.enterNamesOfCars();
        String input = InputView.getInput();
        Cars cars = new Cars(InputView.splitInput(input));
        OutputView.enterNumberOfRounds();
        int numberOfRounds = InputView.getNumberInput();
        OutputView.printExecutionResults();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        for(int i=0; i<numberOfRounds; i++){
            cars.move(randomMoveStrategy);
            OutputView.printCarRacing(cars);
        }
        OutputView.printWinners(cars.getWinners());
    }
}

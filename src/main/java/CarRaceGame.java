public class CarRaceGame {
    public static void main(String[] args) {
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        String names = InputView.inputCarNames();
        Cars cars = new Cars(names);

        int tryNumber = InputView.inputTryNumber();
        for (int i = 0; i < tryNumber; i++) {
            cars.move(moveStrategy);
            ResultView.printLocations(cars.getAllCars());
        }

        ResultView.printWinner(cars.getWinners());
    }
}

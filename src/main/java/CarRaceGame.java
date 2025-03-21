public class CarRaceGame {
    public static void main(String[] args) {
        String names = InputView.inputCarNames();

        GameService gameService = new GameService(names);

        int tryNumber = InputView.inputTryNumber();
        for (int i = 0; i < tryNumber; i++) {
            gameService.move();
            ResultView.printLocations(gameService.getAllCars());
        }
        ResultView.printWinner(gameService.getWinners());
    }
}

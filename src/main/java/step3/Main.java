package step3;

public class Main {
    public static void main(String[] args) {
        String inputNamesOfCars = InputScanner.getInputNamesOfCars();
        int inputNumberOfTry = InputScanner.getInputNumberOfTry();

        RacingGame racingGame = new RacingGame(
                inputNamesOfCars,
                inputNumberOfTry
        );

        racingGame.racingAll();
    }
}

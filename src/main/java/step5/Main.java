package step5;

public class Main {

    public static void main(String[] args) {
        String[] carNames = GameInput.readCarNames();
        int roundCount = GameInput.readRoundCount();
        CarRacingGame carRacingGame = new CarRacingGame(roundCount, carNames);

        System.out.println("실행 결과");
        while (carRacingGame.hasMoreRounds()) {
            carRacingGame.moveCars();
            GameOutput.printCarPaths(carRacingGame);
            System.out.println();
        }

        GameOutput.printWinners(carRacingGame.getWinners());
    }
}

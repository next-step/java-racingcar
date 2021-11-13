package step4;

public class Main {

    public static void main(String[] args) {
        int roundCount = GameInput.readRoundCount();
        String[] carNames = GameInput.readCarNames();
        CarRacingGame carRacingGame = new CarRacingGame(carNames);

        System.out.println("실행 결과");
        for (int i = 0; i < roundCount; i++) {
            carRacingGame.moveCars();
            GameOutput.printCarPaths(carRacingGame);
            System.out.println();
        }

        GameOutput.printWinners(carRacingGame.getWinners());
    }
}

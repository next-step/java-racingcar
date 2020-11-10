package step4;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();

        String carNames = RacingCarUi.receiveRacerInput();
        int numberOfMove = RacingCarUi.receiveMoveInput();

        racingCarGame.start(numberOfMove, carNames);

        RacingCarUi.close();
    }
}

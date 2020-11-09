package step4;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();

        String racer = RacingCarUi.receiveRacerInput();
        int move = RacingCarUi.receiveMoveInput();

        racingCarGame.start(move, racer);

        RacingCarUi.close();
    }
}

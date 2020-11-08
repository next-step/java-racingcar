package step4;

public class RacingCarApplication {
    public static void main(String[] args) {
        String racer = RacingCarUi.receiveRacerInput();
        RacingCarGame.validate(racer);

        String[] racers = racer.split(",");
        int move = RacingCarUi.receiveMoveInput();

        RacingCarGame.getRacers(move, racers);

        RacingCarUi.close();
    }
}

public class RacingCarMain {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController();

        String carNames = controller.inputCarNames();
        int roundNumber = controller.inputRoundNumber();

        controller.game(carNames, roundNumber);
    }
}

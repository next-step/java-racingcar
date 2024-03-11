public class CarRacingApplication {

    public static void main(String[] args) {
        CarRacingGame game = new CarRacingGame();
        game.start(new InputVO(InputView.carInput(), InputView.tryInput()));
    }
}

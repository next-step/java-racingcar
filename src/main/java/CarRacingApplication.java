import view.InputView;

public class CarRacingApplication {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        new InputView()
                .getUserInputForRace();
    }

}

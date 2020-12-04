package racing;

public class RacingMain {
    public static void main(String[] args) {
        Display display = new Display();
        InputUtil inputUtil = new InputUtil();
        CarRacing carRacing = new CarRacing(display, inputUtil);
        carRacing.startRacing();
    }
}

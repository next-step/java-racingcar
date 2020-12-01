package racing;

public class RacingMain {
    public static void main(String[] args) {
        Util inputUtil = new Util();
        Display display = new Display();
        CarRacing carRacing = new CarRacing(display, inputUtil);
        carRacing.startRacing();
    }
}

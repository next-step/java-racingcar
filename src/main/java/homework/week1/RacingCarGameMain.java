package homework.week1;

public class RacingCarGameMain {
    public static void main(String[] args) {
        RacingCarGameFront gameFront = new RacingCarGameFront();
        String carStrings = gameFront.getInputCarStrs();
        int numOfRacing = gameFront.getInputNumberOfRacing();
        RacingCarGameEngine gameEngine = new RacingCarGameEngine(carStrings, numOfRacing);

    }
}

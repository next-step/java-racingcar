package homework.week1;

public class RacingCarGameMain {
    public static void main(String[] args) {
        RacingCarGameFront gameFront = new RacingCarGameFront();
        String carStrings = gameFront.getInputCarStrs();
        int numOfRacing = gameFront.getInputNumberOfRacing();
        RacingCarGameEngine gameEngine = new RacingCarGameEngine(carStrings, numOfRacing);
        for(int racingNumber = 1; racingNumber <= gameEngine.getNumberOfRacing(); racingNumber++) {
            gameEngine.tryRace();
            gameFront.printRacingCars(gameEngine.getCars());
            gameFront.printEmptyLine();
        }
    }
}

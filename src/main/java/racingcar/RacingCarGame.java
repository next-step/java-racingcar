package racingcar;

public class RacingCarGame {
    public static void main(String[] args) {
        UserInput userInput = UserInput.getUserInputFromScanner();
        Race race = userInput.readyForRace();
        race.start();
    }
}

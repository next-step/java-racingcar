package racingcar;

public class RacingCarGame {
    public static void main(String[] args) {
        UserInput userInput = ConsoleInput.getUserInput();
        Race race = userInput.readyForRace();
        race.start();
    }
}

package racingcar;

public class RacingCarGame {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();

        UserInput userInput = input.getUserInput();
        Race race = userInput.readyForRace();
        race.start(output);
    }
}

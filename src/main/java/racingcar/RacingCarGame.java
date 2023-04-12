package racingcar;

public class RacingCarGame {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();

        Race race = input.getUserInput().readyForRace();
        race.start(output);
    }
}

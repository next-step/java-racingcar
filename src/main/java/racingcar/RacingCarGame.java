package racingcar;

public class RacingCarGame {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();

        Race race = input.setRace();

        output.printExecutionHeader();
        while (race.isNotFinished()) {
            race.continueRace(race.randomNumbers());
            output.printPositions(race);
        }
    }
}

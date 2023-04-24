package racingcar;

public class RacingCarGame {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();

        Race race = input.setRaceAndRetryIfInvalid(new RandomMoveStrategy());

        output.printExecutionHeader();
        while (race.isNotFinished()) {
            race.continueRace();
            output.printPositions(race);
        }
        output.printWinner(race);
    }
}

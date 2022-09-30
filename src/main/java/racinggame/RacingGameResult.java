package racinggame;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingGameResult {

    private static final String DISTANCE_SYMBOL = "-";
    private static final String NEW_LINE = "\n";

    private final int[][] result;

    public RacingGameResult(int round, int numOfSize) {
        this.result = new int[round][numOfSize];
    }

    public void writeResult(int indexOfRound, int indexOfCar, int positionOfCar) {
        this.result[indexOfRound][indexOfCar] = positionOfCar;
    }

    public String getContent() {
        return Arrays.stream(result)
                .map(this::joinRound)
                .collect(Collectors.joining(NEW_LINE.repeat(2)));
    }

    private String joinRound(int[] round) {
        return Arrays.stream(round)
                .mapToObj(DISTANCE_SYMBOL::repeat)
                .collect(Collectors.joining(NEW_LINE));
    }

    public boolean isEqualResult(int indexOfRound, int indexOfCar, int value) {
        return result[indexOfRound][indexOfCar] == value;
    }

    public int getNumOfRound() {
        return result.length;
    }

}

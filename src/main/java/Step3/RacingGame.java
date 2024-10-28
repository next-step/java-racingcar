package Step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final RacingCar[] cars;
    private final List<List<Integer>> gameRecord;
    private final int playNum;

    public RacingGame(String[] carNames, int playNum) {
        this.cars = new RacingCar[carNames.length];
        this.gameRecord = new ArrayList<>();

        int idx = 0;
        for (String carName : carNames) {
            this.cars[idx] = new RacingCar(carName, 0);
            idx++;
        }

        this.playNum = playNum;
    }

    public RacingCar[] getCars() {
        return this.cars;
    }

    public List<List<Integer>> play(int[][] playRands) throws Exception {
        if (playRands == null || playRands.length == 0) {
            throw new Exception("playRands is null or empty");
        }

        if (playRands.length != this.playNum) {
            throw new Exception("playRands.length != this.playNum");
        }

        for (int i = 0; i < this.playNum; i++) {
            List<Integer> turnRecord = tryMoveCars(playRands[i]);

            this.gameRecord.add(turnRecord);
        }

        return this.gameRecord;
    }

    private List<Integer> tryMoveCars(int[] carRands) throws Exception {
        if (carRands == null || carRands.length == 0) {
            throw new Exception("carRands is null or empty");
        }

        if (carRands.length != this.cars.length){
            throw new Exception("mismatched cars' random list size");
        }

        List<Integer> turnRecord = new ArrayList<>();

        int idx = 0;
        for (RacingCar car : this.cars) {
            int position = car.move(carRands[idx]);

            turnRecord.add(position);
            idx++;
        }

        return turnRecord;
    }

    public List<RacingCar> getWinner() {
        List<RacingCar> winners = new ArrayList<>();
        List<Integer> lastTurnRecord = this.gameRecord.get(this.gameRecord.size() - 1);

        int max = calculateMax(lastTurnRecord);

        for (int i = 0; i < lastTurnRecord.size(); i++) {
            pickIfWinner(lastTurnRecord, i, max, winners);
        }

        return winners;
    }

    private int calculateMax(List<Integer> lastTurnRecord) {
        int max = 0;
        for (Integer finalPosition : lastTurnRecord) {
            max = isMax(finalPosition, max);
        }
        return max;
    }

    private void pickIfWinner(List<Integer> lastTurnRecord, int i, int max, List<RacingCar> winners) {
        if (lastTurnRecord.get(i) == max) {
            winners.add(this.cars[i]);
        }
    }

    private int isMax(Integer finalPosition, int max) {
        if (finalPosition > max) {
            max = finalPosition;
        }
        return max;
    }
}

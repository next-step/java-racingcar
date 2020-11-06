package racingcar;

import java.util.LinkedHashMap;

public class GameRounds {
    private final RoundRecords roundRecords;
    private int round;

    public GameRounds(int round) {
        this.round = round;
        this.roundRecords = new RoundRecords(round);
    }

    public void endRound() {
        round--;
    }

    public void keepRecord(Cars cars) {
        LinkedHashMap<String, Integer> positions = new LinkedHashMap<>();
        cars.getCarList().forEach(car -> positions.put(car.getName(), car.getPosition()));
        this.roundRecords.addRecord(new RoundRecord(positions));
    }

    public boolean isGameEnd() {
        return round == 0;
    }

    public RoundRecords getRecords() {
        return roundRecords;
    }
}

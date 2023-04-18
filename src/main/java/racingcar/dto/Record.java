package racingcar.dto;

public class Record {

    private final String carName;
    private final Integer moveCount;

    public Record(String carName, Integer moveCount) {
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public String getCarName() {
        return carName;
    }

    public Integer getMoveCount() {
        return moveCount;
    }
}

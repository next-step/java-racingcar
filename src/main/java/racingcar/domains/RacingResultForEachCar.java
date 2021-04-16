package racingcar.domains;

import java.util.List;

public class RacingResultForEachCar {

    private String carName;

    private int carPosition;

    public RacingResultForEachCar(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    //    private final List<Integer> records;
//
//    public RacingResult(List<Integer> records) {
//        this.records = records;
//    }

//    public List<Integer> getRecords() {
//        return records;
//    }

}

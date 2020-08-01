package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    private final List<RaceRecord> carRaceRecords;

    private Car(List<RaceRecord> carRaceRecords) {
        this.carRaceRecords = carRaceRecords;
    }

    public static List<Car> ofRacingCarReady(Input input) {
        return IntStream.range(0, input.getCarNo())
                        .mapToObj(i -> ofRaceCarRecord(input.getTotalLaps()))
                        .collect(Collectors.toCollection(() -> new ArrayList<>(input.getCarNo())));
    }

    protected static Car ofRaceCarRecord(int totalRound) {
        return new Car(RaceRecord
                           .of()
                           .ofRecordResult(totalRound));
    }

    public List<RaceRecord> getCarRaceRecords() {
        return carRaceRecords;
    }
}

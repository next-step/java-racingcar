package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Records {

    private List<CarRecord> carRecords;
    private int winnerLocation;

    public Records(List<CarRecord> carRecords) {
        this.carRecords = carRecords;
        this.winnerLocation = findWinnerLocation();
    }

    private int findWinnerLocation() {
        int location = 0;
        for (CarRecord carRecord : carRecords) {
            location = Math.max(carRecord.getLocation(), location);
        }

        return location;
    }

    public List<String> findWinners() {
        return carRecords.stream()
                .filter(c -> c.equalsLocation(winnerLocation))
                .map(CarRecord::getName)
                .collect(Collectors.toList());
    }

    public List<CarRecord> getCarRecords() {
        return carRecords;
    }
}

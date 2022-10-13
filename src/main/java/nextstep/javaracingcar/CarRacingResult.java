package nextstep.javaracingcar;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarRacingResult implements Iterable<CarDrivingResult> {

    private final List<CarDrivingResult> drivingResults;

    public CarRacingResult(final List<CarDrivingResult> drivingResults) {
        this.drivingResults = drivingResults;
    }

    public List<CarDrivingResult> winners() {
        final Distance maxDistance = maxDistance();
        return drivingResults.stream().filter(r -> r.isPosition(maxDistance)).collect(Collectors.toList());
    }

    @Override
    public Iterator<CarDrivingResult> iterator() {
        return drivingResults.iterator();
    }

    private Distance maxDistance() {
        final Optional<Distance> max = drivingResults.stream().map(CarDrivingResult::distance).max(Distance::compareTo);
        return max.orElseThrow(() -> new IllegalStateException("경주 중인 자동차가 없습니다."));
    }
}

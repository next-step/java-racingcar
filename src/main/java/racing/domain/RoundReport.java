package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RoundReport {

    private final List<CarReport> carReports;

    public RoundReport(final List<CarReport> carReports) {
        this.carReports = new ArrayList<>(Collections.unmodifiableList(carReports));
    }

    public static RoundReport of(final List<CarReport> carReports) {
        return new RoundReport(carReports);
    }

    public List<CarReport> getCarReports() {
        return new ArrayList<>(carReports);
    }

    public List<String> winner() {
        int winnerLocation = winnerLocation();
        return carReports.stream()
                .filter(carReport -> carReport.isLocation(winnerLocation))
                .map(CarReport::getName)
                .collect(Collectors.toList());
    }

    private int winnerLocation() {
        return carReports.stream()
                .max(Comparator.comparing(CarReport::getLocation))
                .orElseThrow(IllegalArgumentException::new)
                .getLocation();
    }
}

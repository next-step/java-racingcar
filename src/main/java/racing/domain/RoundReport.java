package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}

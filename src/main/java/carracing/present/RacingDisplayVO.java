package carracing.present;

import carracing.model.Racer;

import java.util.List;

public class RacingDisplayVO {
    private final String carName;
    private final List<String> results;

    public RacingDisplayVO(Racer racer) {
        carName = racer.carName();
        results = racer.positionPresentation();
    }

    public String getCarName() {
        return carName;
    }

    public List<String> getResults() {
        return results;
    }
}

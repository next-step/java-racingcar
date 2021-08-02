package carracing.domain;

import java.util.List;

public class RaceResult {

    private String raceResult;

    public RaceResult() {
        this.raceResult = "";
    }

    public String raceResult() {
        return raceResult;
    }

    public void saveResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> {
            sb.append(car.location());
            sb.append("\n");
        });
        sb.append("\n");
        raceResult = sb.toString();
    }

}

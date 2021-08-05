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
            sb.append(car.name() + " : ");
            sb.append(makeLocation(car.location()));
            sb.append("\n");
        });
        raceResult = sb.toString();
    }

    private String makeLocation(int location) {
        String result = "";
        for (int i = 0; i < location; i++) {
            result += "-";
        }
        return result;
    }

}

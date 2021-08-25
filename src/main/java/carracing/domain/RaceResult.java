package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {

    private List<String> raceResult;

    private List<Car> winners;

    public RaceResult(int raceCount) {
        this.raceResult = new ArrayList<>(raceCount);
        this.winners = new ArrayList<>();
    }

    public List<String> raceResult() {
        return raceResult;
    }

    public List<Car> winners() {
        return winners;
    }

    public void saveResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> {
            sb.append(car.name() + " : ");
            sb.append(makeLocation(car.position().value()));
            sb.append("\n");
        });
        raceResult.add(sb.toString());
    }

    public void saveWinners(List<Car> winners) {
        this.winners = winners;
    }

    private String makeLocation(int location) {
        String result = "";
        for (int i = 0; i < location; i++) {
            result += "-";
        }
        return result;
    }

}

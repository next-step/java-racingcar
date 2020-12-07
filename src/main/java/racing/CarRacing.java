package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {
    private ParticipateCars participateCars;
    private Display display;

    public CarRacing(ParticipateCars participateCars, Display display) {
        this.participateCars = participateCars;
        this.display = display;
    }

    public void startRacing(int racingCount) {
        for (int i = 0; i < racingCount; i++) {
            this.participateCars.moveCar();
            display.displayRacingResult(this.participateCars);
        }
    }

    public String winner() {
        int numOfWinnerByCondition = 2;
        List<Car> cars = this.participateCars.getCars();
        List<String> winner = new ArrayList<>();
        winner = compareCarsTotalMeter(winner, cars);
        return winnerName(winner, numOfWinnerByCondition);
    }

    private List<String> compareCarsTotalMeter(List<String> winner, List<Car> cars) {
        List<String> candidate = new ArrayList<>(winner);
        int maxMeter = 0;
        for (Car car : cars) {
            if (maxMeter == car.totalMeter()) {
                maxMeter = car.totalMeter();
                candidate.add(car.getName());
            }
            if (maxMeter < car.totalMeter()) {
                maxMeter = car.totalMeter();
                candidate = new ArrayList<>();
                candidate.add(car.getName());
            }
        }
        return new ArrayList<>(candidate);
    }

    private String winnerName(List<String> winners, int numOfWinnerOption) {
        String winner = "";
        if (winners.size() < numOfWinnerOption) {
            winner = winners.get(0);
        }
        if (winners.size() > numOfWinnerOption || winners.size() == numOfWinnerOption) {
            winner = winners.stream().collect(Collectors.joining(","));
        }
        return winner;
    }
}

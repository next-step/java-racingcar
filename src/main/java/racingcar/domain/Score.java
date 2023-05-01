package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class Score {
    private final String score;

    public Score(List<Car> carList) {
        this.score = convertScore(carList);
    }

    public String getScore() {
        return score;
    }

    private String convertScore(List<Car> carList) {
        StringBuilder score = new StringBuilder();
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            String driven = convertDriven(car.distanceDriven());
            score.append(car.name())
                    .append(" : ")
                    .append(driven)
                    .append("\n");
        }
        return score.toString();
    }

    private String convertDriven(int distanceDriven) {
        return "-".repeat(Math.max(0, distanceDriven));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score)) return false;

        Score score1 = (Score) o;
        return Objects.equals(score, score1.score);
    }

    @Override
    public int hashCode() {
        return score != null ? score.hashCode() : 0;
    }
}

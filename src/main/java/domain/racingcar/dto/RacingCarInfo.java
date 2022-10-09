package domain.racingcar.dto;

import java.util.Objects;

public class RacingCarInfo {
    private final String name;
    private int distance;

    public RacingCarInfo(int distance) {
        this(distance, "");
    }

    public RacingCarInfo(int distance, String name) {
        this.distance = distance;
        this.name = name;
    }

    public int plusDistance() {
        distance += 1;
        return distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarInfo that = (RacingCarInfo) o;
        return distance == that.distance && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, name);
    }

    public boolean hasRaceWinnerDistance(int raceWinnerDistance) {
        return distance == raceWinnerDistance;
    }
}

package domain;

import domain.dto.RacingCarPosition;

import java.util.List;
import java.util.stream.Collectors;

public class RacingRound {

    private final List<RacingCarPosition> carPositions;

    private RacingRound(List<RacingCarPosition> carPositions) {
        this.carPositions = carPositions;
    }

    public static RacingRound newInstance(List<RacingCarPosition> carPositions) {
        validate(carPositions);
        return new RacingRound(carPositions);
    }

    private static void validate(List<RacingCarPosition> carPositions) {
        if (carPositions == null || carPositions.size() == 0) {
            throw new RuntimeException("car positions is null or empty.");
        }
    }

    public List<RacingCarPosition> getCarPositions() {
        return this.carPositions;
    }

    public List<String> getWinners() {
        Integer winnerScore = carPositions.stream()
                .mapToInt(RacingCarPosition::getLocationPoint)
                .max()
                .orElseThrow(() -> new RuntimeException("Winner does not existed."));

        return carPositions.stream()
                .filter(carPosition -> winnerScore.equals(carPosition.getLocationPoint()))
                .map(RacingCarPosition::getName)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RacingRound) {
            return carPositions.equals(((RacingRound) obj).carPositions);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return carPositions.hashCode();
    }
}

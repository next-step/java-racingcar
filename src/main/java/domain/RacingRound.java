package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingRound {
    private final List<RacingCarPosition> carPositions;

    private RacingRound(List<RacingCarPosition> carPositions) {
        this.carPositions = carPositions;
    }

    public static RacingRound newInstance(RacingCarPosition[] carPositionArray) {
        List<RacingCarPosition> carPositions = Arrays.stream(carPositionArray)
                .collect(Collectors.toList());
        return newInstance(carPositions);
    }

    public static RacingRound newInstance(List<RacingCarPosition> carPositions) {
        validate(carPositions);
        return new RacingRound(carPositions);
    }

    private static void validate(List<RacingCarPosition> carPositions) {
        if (carPositions == null || carPositions.size() < 0) {
            throw new RuntimeException("car positions must be greater than zero.");
        }

        validatePositions(carPositions);
    }

    private static void validatePositions(List<RacingCarPosition> carPositions) {
        boolean hasNegativeNumber = carPositions.stream()
                .anyMatch(position -> position.getLocationPoint() < 0);

        if (hasNegativeNumber) {
            throw new RuntimeException("car positions must be greater than zero.");
        }
    }

    public List<RacingCarPosition> getCarPositions() {
        return this.carPositions;
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

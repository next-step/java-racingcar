package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RacingRound {
    private final List<Integer> carPositions;

    private RacingRound(List<Integer> carPositions) {
        this.carPositions = carPositions;
    }

    public static RacingRound newInstance(int[] carPositionArray) {
        List<Integer> carPositions = Arrays.stream(carPositionArray)
                .boxed()
                .collect(Collectors.toList());
        return newInstance(carPositions);
    }

    public static RacingRound newInstance(List<Integer> carPositions) {
        validate(carPositions);
        return new RacingRound(carPositions);
    }

    private static void validate(List<Integer> carPositions) {
        if (carPositions == null || carPositions.size() < 0) {
            throw new RuntimeException("car positions must be greater than zero.");
        }

        validatePositions(carPositions);
    }

    private static void validatePositions(List<Integer> carPositions) {
        boolean hasNegativeNumber = carPositions.stream()
                .anyMatch(position -> position < 0);
        if(hasNegativeNumber) {
            throw new RuntimeException("car positions must be greater than zero.");
        }
    }

    public List<Integer> getCarPositions() {
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

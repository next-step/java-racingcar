package step2.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class GameResult {
    private static final int INITIAL_PHASE_INDEX = 0;

    private final int numberOfPhases;
    private final int numberOfCars;
    private final Map<Integer, Phase> carSnapshotsBySimulatePhase;

    public GameResult(
            final int numberOfPhases,
            final int numberOfCars,
            final Map<Integer, Phase> carSnapshotsBySimulatePhase) {
        this.numberOfCars = numberOfCars;
        this.numberOfPhases = numberOfPhases;
        this.carSnapshotsBySimulatePhase = Collections.unmodifiableMap(carSnapshotsBySimulatePhase);
    }

    public List<Phase> getAllPhase() {
        return IntStream.range(INITIAL_PHASE_INDEX, numberOfPhases)
                        .mapToObj(carSnapshotsBySimulatePhase::get)
                        .collect(Collectors.toList());
    }

    public Phase getPhase(final int at) {
        if (!carSnapshotsBySimulatePhase.containsKey(at)) {
            throw new IllegalArgumentException();
        }
        return carSnapshotsBySimulatePhase.get(at);
    }

    public int getNumberOfPhases() {
        return numberOfPhases;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public static Builder builder(final int numberOfPhases, final int numberOfCars) {
        return new Builder(numberOfPhases, numberOfCars);
    }

    public static class Builder {
        private final int numberOfPhases;
        private final int numberOfCars;
        private final Map<Integer, Phase> carSnapshotsBySimulatePhase = new HashMap<>();

        public Builder(final int numberOfPhases, final int numberOfCars) {
            this.numberOfPhases = numberOfPhases;
            this.numberOfCars = numberOfCars;
        }

        public void addPhase(final int currentPhase, final List<Car> carSnapshot) {
            carSnapshotsBySimulatePhase.put(currentPhase, new Phase(currentPhase, carSnapshot));
        }

        public GameResult build() {
            return new GameResult(numberOfPhases, numberOfCars, carSnapshotsBySimulatePhase);
        }
    }

    public static class Phase {
        private final int index;
        private final List<Car> cars;

        public Phase(final int index, final List<Car> cars) {
            this.index = index;
            this.cars = cars;
        }

        public List<Car> getAllCars() {
            return cars;
        }

        @Override
        public String toString() {
            return String.format("phase %s : %s", index, cars);
        }
    }
}

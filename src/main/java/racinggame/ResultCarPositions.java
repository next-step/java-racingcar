package racinggame;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultCarPositions {

    private final List<int[]> carPositions;

    private ResultCarPositions(List<int[]> carPositions) {
        validateCarPositions(carPositions);
        this.carPositions = carPositions;
    }

    public static ResultCarPositions newInstance(List<int[]> carPositions) {
        return new ResultCarPositions(carPositions);
    }

    public int getCarCount() {
        return this.carPositions.get(0).length;
    }

    public int getTotalRound() {
        return this.carPositions.size();
    }

    public int[] getPositions(int round) {
        return this.carPositions.get(round);
    }

    private void validateCarPositions(List<int[]> carPositions) {
        if (carPositions == null) {
            throw new IllegalArgumentException("자동차 경주 결과가 존재하지 않습니다.");
        }

        if (carPositions.size() == 0) {
            throw new IllegalArgumentException("자동차 경주 결과가 한 건 이상 존재해야 합니다.");
        }

        Set<Integer> carCount = getNonDuplicateCarCount(carPositions);
        if (!isValidCountOfCars(carCount)) {
            throw new IllegalArgumentException("유효하지 않은 자동차 수가 존재합니다.");
        }
    }

    private Set<Integer> getNonDuplicateCarCount(List<int[]> carPositions) {
        return carPositions.stream()
                .map(result -> result == null ? 0 : result.length)
                .collect(Collectors.toSet());
    }

    private boolean isValidCountOfCars(Set<Integer> carCount) {
        return carCount.size() == 1 && !carCount.contains(0);
    }
}

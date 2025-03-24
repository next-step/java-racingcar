public class GameSettings {

    private final String[] carNames;
    private final int roundCount;

    public GameSettings(String[] carNames, int roundCount) {
        validateCarNames(carNames);
        validateRoundCount(roundCount);

        this.carNames = carNames;
        this.roundCount = roundCount;
    }

    private void validateCarNames(String[] carNames) {
        if (carNames == null || carNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름 목록이 비어있습니다.");
        }
        for (String name : carNames) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
            }
        }
    }

    private void validateRoundCount(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getCarCount() {
        return carNames.length;
    }

    public int getRoundCount() {
        return roundCount;
    }
}

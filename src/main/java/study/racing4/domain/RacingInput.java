package study.racing4.domain;

public class RacingInput {

    private final String[] cars;
    private final int countOfRound;

    public RacingInput(String rawCarsString, int countOfRound) {
        validateBlank(rawCarsString);
        validateCountOfRound(countOfRound);
        this.cars = parseCarsString(rawCarsString);
        this.countOfRound = countOfRound;
    }

    private void validateBlank(String rawCarsString) {
        if(rawCarsString.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 입력값이 비어 있습니다.");
        }

    }
    private void validateCountOfRound(int countOfRound) {
        if (countOfRound <= 0) {
            throw new IllegalArgumentException("라운드 수는 0 보다 커야합니다.");
        }
    }

    private String[] parseCarsString(String rawCarsString) {
        return rawCarsString.split(",");
    }

    public String[] getCars() {
        return cars;
    }

    public int getCountOfRound() {
        return countOfRound;
    }
}

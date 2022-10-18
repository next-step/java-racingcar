package racingcar.race;

public class RacingModel {
    protected static final int MOVE_POSSIBLE = 4;
    private int tryCount;
    private String[] names;

    public RacingModel(String[] names, int tryCount) {
        if (tryCount < 0) {
            throw new RuntimeException("0보다 큰 수를 입력하세요");
        }
        this.names = names;
        this.tryCount = tryCount;
    }

    public void racingStart(RacingCars racingCars) {
        final NumberGenerator numberGenerator = new RandomNumberGenerator();
        for (Car car : racingCars.getRacingCars()) {
            car.move(numberGenerator);
        }
    }

    public static boolean isMovePossible(int number) {
        if (number >= MOVE_POSSIBLE) {
            return true;
        }
        return false;
    }

    public String[] getNames() {
        return names;
    }
    public int getTryCount() {
        return tryCount;
    }
    public int getNumberOfUser() {
        return this.names.length;
    }
}

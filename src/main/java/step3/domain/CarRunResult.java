package step3.domain;

public class CarRunResult {

    public static final char PROGRESS_SYMBOL = '-';
    private static final String COLON_DELIMITER = " : ";

    private String carName;
    private int runDistance;

    public CarRunResult(String carName, int runDistance) {
        this.carName = carName;
        this.runDistance = runDistance;
    }

    public String generateCarRunResultString() {
        return carName + COLON_DELIMITER + generateProgressString(runDistance);
    }

    private String generateProgressString(int runDistance) {
        String progress = "";
        for (int i = 0; i < runDistance; i++) {
            progress = progress + PROGRESS_SYMBOL;
        }
        return progress;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public String getCarName() {
        return carName;
    }
}

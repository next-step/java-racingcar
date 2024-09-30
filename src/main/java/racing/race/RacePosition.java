package racing.race;

public enum RaceGauge {

    STOP(0, ""),
    FORWARD(1,"-");

    private final int value;
    private final String resultMark;

    RaceGauge(int value, String resultMark) {
        this.value = value;
        this.resultMark = resultMark;
    }

    public String getResultMark() {
        return resultMark;
    }
}

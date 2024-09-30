package racing.race;

public enum RacePosition {

    STOP(0, ""),
    FORWARD(1,"-");

    private final int value;
    private final String resultMark;

    RacePosition(int value, String resultMark) {
        this.value = value;
        this.resultMark = resultMark;
    }

    public String getResultMark() {
        return resultMark;
    }
}

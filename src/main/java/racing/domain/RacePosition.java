package racing.domain;

public enum RacePosition {

    STOP(0, ""),
    FORWARD(1,"-");

    private final int point;
    private final String resultMark;

    RacePosition(int value, String resultMark) {
        this.point = value;
        this.resultMark = resultMark;
    }

    public String getResultMark() {
        return resultMark;
    }

    public int getPoint() {
        return point;
    }
}

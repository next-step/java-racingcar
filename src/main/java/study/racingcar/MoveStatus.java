package study.racingcar;

public enum MoveStatus {
    MOVE, STOP;

    public String moveString() {
        if (this.equals(MoveStatus.MOVE)) {
            return "-";
        }
        return "";
    }

}

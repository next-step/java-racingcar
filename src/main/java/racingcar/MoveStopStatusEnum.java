package racingcar;

public enum MoveStopStatusEnum {
    MOVE("M", "-"),
    STOP("S", "");

    private final String status;
    private final String moveLength;

    MoveStopStatusEnum(String status, String moveLength) {
        this.status = status;
        this.moveLength = moveLength;
    }

    public String getStatus() {
        return status;

    }



    public String getMoveLength() {
        return moveLength;
    }

    public static MoveStopStatusEnum getEnumByStatus(String status) {
        for (MoveStopStatusEnum item : values()) {
            if (item.getStatus().equals(status)) {
                return item;
            }
        }
        return null ;
    }
}

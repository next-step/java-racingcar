package step2.eumSet;

public enum StatusNumber {

    EXCUTE_STANDARD(4),
    EXCUTE(1),
    STOP(0);

    private int number;

    StatusNumber(int number) {
        this.number = number;
    }

    public int getValue() {
        return this.number;
    }

}

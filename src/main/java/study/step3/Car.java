package study.step3;

public enum Car {
    MIN_INPUT_NUMBER(1),
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    MIN_FORWARD_NUMBER(4),
    MOVE_NUMBER(1);

    private int paramNumber;

    Car(int paramNumber) {
        this.paramNumber = paramNumber;
    }

//    public String minus;
//
//    Car(int moveSpace, String minus) {
//        this.moveSpace = moveSpace;
//        this.minus = minus;
//    }

}

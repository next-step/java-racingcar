package racing;

import java.util.Arrays;

public enum MoveStatus {

    STAY(0, 3),
    GO(4, 9);

    private final int startNumber;
    private final int endNumber;

    MoveStatus(int startNumber, int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    public static MoveStatus findByNumber(int number) {
        return Arrays.stream(MoveStatus.values())
                .filter(moveStatus -> moveStatus.betweenNumber(number))
                .findAny()
                .orElse(null);
    }

    public boolean betweenNumber(int number) {
        return this.startNumber <= number && this.endNumber >= number;
    }

}

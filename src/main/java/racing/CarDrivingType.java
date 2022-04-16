package racing;

public enum CarDrivingType {
    GO,
    STOP;

    public static CarDrivingType GetRandom() {
        return CarDrivingType.from(RandomMoveNumber.generate());
    }

    public static CarDrivingType from(int x) {
        if (x < 0) {
            return STOP;
        }
        if (x >= 4 && x <= 9) {
            return GO;
        }

        return STOP;
    }
}

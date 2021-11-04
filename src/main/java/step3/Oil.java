package step3;

public enum Oil {
    GOOD,
    BAD;

    private static final int averageQuality = 4;

    public static Oil create(int materialQuality) {
        if (isGoodMaterial(materialQuality)) {
            return GOOD;
        }
        return BAD;
    }

    private static boolean isGoodMaterial(int materialQuality) {
        return materialQuality >= averageQuality;
    }

    public Power burn() {
        if (this == GOOD) {
            return Power.SUFFICIENT;
        }
        return Power.INSUFFICIENT;
    }

}

package step3;

public enum Oil {
    GOOD,
    BAD;

    public static Oil create(Material material) {
        if (material == Material.HIGH_QUALITY) {
            return GOOD;
        }
        return BAD;
    }

    public Power burn() {
        if (this == GOOD) {
            return Power.SUFFICIENT;
        }
        return Power.INSUFFICIENT;
    }

}

package step3;

import java.util.Random;

public enum Material {
    HIGH_QUALITY,
    LOW_QUALITY;

    private static final Random random = new Random();

    public static Material createRandom() {
        if (random.nextInt() >= 4) {
            return HIGH_QUALITY;
        }
        return LOW_QUALITY;
    }

}

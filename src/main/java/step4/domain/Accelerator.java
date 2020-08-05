package step4.domain;

import java.util.Random;

public class Accelerator {
    private static final Random generator = new Random();
    private static int ACCELERATION_MINIMUM_STANDARDS = 4;
    private static int ACCELERATION_MAXIMUM_STANDARDS = 10;

    public Accelerator() {
    }

    public Accelerator(int ACCELERATION_MINIMUM_STANDARDS, int ACCELERATION_MAXIMUM_STANDARDS) {
        this.ACCELERATION_MINIMUM_STANDARDS = ACCELERATION_MINIMUM_STANDARDS;
        this.ACCELERATION_MAXIMUM_STANDARDS = ACCELERATION_MAXIMUM_STANDARDS;
    }

    public static Accelerator ofAccelerator() {
        return new Accelerator();
    }

    public static Accelerator ofCustomAccelerator(int ACCELERATION_MINIMUM_STANDARDS, int ACCELERATION_MAXIMUM_STANDARDS) {
        return new Accelerator(ACCELERATION_MINIMUM_STANDARDS,
                ACCELERATION_MAXIMUM_STANDARDS);
    }

    public static boolean accelerate() {
        return ACCELERATION_MINIMUM_STANDARDS <= generator.nextInt(ACCELERATION_MAXIMUM_STANDARDS);
    }
}

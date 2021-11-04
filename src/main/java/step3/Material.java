package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static step3.utils.ValidationUtils.checkArgument;

public enum Material {
    HIGH_QUALITY,
    LOW_QUALITY;

    private static final int DEFAULT_BOUND = 4;
    private static final Random random = new Random();

    public static List<Material> createRandoms(Long materialCount) {
        checkArgument(materialCount != null, "materialCount is required");

        List<Material> materials = new ArrayList<>();
        for (int i = 0; i < materialCount; i++) {
            materials.add(createRandom());
        }
        return materials;
    }

    public static Material createRandom() {
        if (random.nextInt(10) >= DEFAULT_BOUND) {
            return HIGH_QUALITY;
        }
        return LOW_QUALITY;
    }

}

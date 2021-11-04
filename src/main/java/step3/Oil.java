package step3;

import java.util.List;

import static java.util.stream.Collectors.toList;

public enum Oil {
    GOOD,
    BAD;

    public static List<Oil> createOils(List<Material> materials) {
        return materials.stream()
                .map(Oil::create)
                .collect(toList());
    }

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

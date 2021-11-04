package step3;

import java.util.List;

import static step3.utils.ValidationUtils.checkArgument;

public class OilStation {

    public static OilTank createOilTank(List<Material> materials) {
        checkArgument(materials != null, "materials is required");
        List<Oil> oils = Oil.createOils(materials);
        return OilTank.fill(oils);
    }
}

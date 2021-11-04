package step3;

import java.util.List;
import java.util.Stack;

public class OilTank {

    private final Stack<Oil> oils = new Stack<>();

    public static OilTank fill(List<Oil> oils) {
        return new OilTank(oils);
    }

    OilTank(List<Oil> oils) {
        validateNotNull(oils);
        this.oils.addAll(oils);
    }

    private void validateNotNull(List<Oil> oils) {
        if (oils == null) {
            throw new IllegalArgumentException("oils is required");
        }
    }

    public Power use() {
        validateNotEmpty();
        Oil oil = oils.pop();
        return oil.burn();
    }

    private void validateNotEmpty() {
        if (oils.isEmpty()) {
            throw new IllegalArgumentException("oilTank is empty.");
        }
    }
}

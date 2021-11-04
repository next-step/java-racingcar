package step3;

import java.util.List;
import java.util.Stack;

public class OilTank {

    private final Stack<Oil> oils = new Stack<>();

    public static OilTank fill(List<Oil> oils) {
        return new OilTank(oils);
    }

    public OilTank(List<Oil> oils) {
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
        if (isEmpty()) {
            throw new IllegalArgumentException("oilTank is empty.");
        }
    }

    public boolean isEmpty() {
        return oils.isEmpty();
    }

    @Override
    public String toString() {
        return "OilTank{" +
                "oils=" + oils +
                '}';

    }

}

package step3;

import java.util.List;
import java.util.Stack;

import static step3.utils.ValidationUtils.checkArgument;
import static step3.utils.ValidationUtils.checkState;

public class OilTank {

    private final Stack<Oil> oils = new Stack<>();

    public static OilTank fill(List<Oil> oils) {
        return new OilTank(oils);
    }

    public OilTank(List<Oil> oils) {
        checkArgument(oils != null, "oils is required");
        this.oils.addAll(oils);
    }

    public Power use() {
        checkState(isNotEmpty(), "oilTank is empty.");
        Oil oil = oils.pop();
        return oil.burn();
    }

    public boolean isNotEmpty() {
        return !oils.isEmpty();
    }

    @Override
    public String toString() {
        return "OilTank{" +
                "oils=" + oils +
                '}';

    }

}

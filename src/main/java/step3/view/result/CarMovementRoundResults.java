package step3.view.result;

import java.util.ArrayList;
import java.util.List;

public class CarMovementRoundResults {
    private final List<CarMovementRoundResult> results = new ArrayList<>();

    public void add(CarMovementRoundResult roundResult) {
        results.add(roundResult);
    }

}

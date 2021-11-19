package step4.dto;

import step4.common.Number;
import step4.dto.count.Count;

public class RandomStrategy implements RunStrategy {

    private static final Count RUN_CONDITION_VALUE = new Count(Number.FOUR.getValue());

    @Override
    public boolean runnable(Count count) {
        return count.moreThanOther(RUN_CONDITION_VALUE);
    }
}

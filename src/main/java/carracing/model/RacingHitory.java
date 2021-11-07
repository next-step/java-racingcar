package carracing.model;

import carracing.util.ExceptionUtils;
import java.util.ArrayList;
import java.util.List;

public class RacingHitory {

    private static final Integer FROM_INDEX = 0;

    private List<Boolean> isTrySuccess;

    public RacingHitory() {
        this.isTrySuccess = new ArrayList<>();
    }

    public void addHistory(Boolean run) {
        isTrySuccess.add(run);
    }

    public List<Boolean> getIsTrySuccess(int toIndex) {
        try {
            return isTrySuccess.subList(FROM_INDEX, toIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException(ExceptionUtils.RACING_HISTORY_INDEX_OUT_BOUND_EXCEPTION);
        }
    }

    public long getSuccessCountByIndex(Integer toIndex) {
        return this.getIsTrySuccess(toIndex)
            .stream()
            .filter(Boolean::booleanValue)
            .count();
    }

}

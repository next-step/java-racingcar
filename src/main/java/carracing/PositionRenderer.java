package carracing;

import java.util.Collections;

public class PositionRenderer {

    private static final IllegalArgumentException INVALID_POSITION_EXCEPTION = new IllegalArgumentException("유효하지 않은 포지션입니다.");
    private static final String POSITION_RENDER_DELIMITER = "";
    private static final String POSITION_SYMBOL = "-";

    public static String render(Position position) {
        validateInvalidPosition(position);
        return String.join(POSITION_RENDER_DELIMITER, Collections.nCopies(position.getValue(), POSITION_SYMBOL));
    }

    private static void validateInvalidPosition(Position position) {
        if (position == null) {
            throw INVALID_POSITION_EXCEPTION;
        }
    }
}

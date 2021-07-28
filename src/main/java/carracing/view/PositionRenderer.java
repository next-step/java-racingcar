package carracing.view;

import carracing.domain.Position;

import java.util.Collections;

public class PositionRenderer {

    private static final IllegalArgumentException INVALID_POSITION_EXCEPTION = new IllegalArgumentException("유효하지 않은 포지션입니다.");
    private static final String POSITION_RENDER_DELIMITER = "";
    private static final String POSITION_EXPRESSION = "-";

    private final Position position;

    private PositionRenderer(Position position) {
        validateNonNull(position);
        this.position = position;
    }

    public static PositionRenderer of(Position position) {
        return new PositionRenderer(position);
    }

    public String render() {
        return String.join(POSITION_RENDER_DELIMITER, Collections.nCopies(position.getValue(), POSITION_EXPRESSION));
    }

    private void validateNonNull(Position position) {
        if (position == null) {
            throw INVALID_POSITION_EXCEPTION;
        }
    }
}

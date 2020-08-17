package racing.core.domain;

import racing.core.patterns.MoveStrategy;
import racing.core.dto.TrackInfo;

public class Car {

    private int position;

    public TrackInfo move(MoveStrategy movement) {
        if (movement.canMove()) {
            position++;
        }
        return new TrackInfo(position);
    }
}

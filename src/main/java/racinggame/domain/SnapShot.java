package racinggame.domain;


import java.util.List;
import racinggame.dto.CarDto;

public class SnapShot {

    private final List<CarDto> snapShot;

    public SnapShot(List<CarDto> snapShot) {
        this.snapShot = snapShot;
    }

    public List<CarDto> history() {
        return snapShot;
    }
}

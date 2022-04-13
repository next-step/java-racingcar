package racing.module.map;

import java.util.List;

public interface RacingMap {

    List<String> getMap();

    void drawCar(int currentPosition);
}

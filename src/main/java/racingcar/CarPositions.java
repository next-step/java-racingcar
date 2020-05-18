package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarPositions {

    private List<CarPosition> positions = new ArrayList<>();

    public void add(CarPosition carPosition) {
        positions.add(carPosition);
    }

    public int size() {
        return positions.size();
    }

    public CarPosition get(int index) {
        return positions.get(index);
    }

    public List<String> getLeaders() {
        List<String> names = new ArrayList<>();
        int maxPosition = 0;

        for (CarPosition carPosition : positions) {
            int position = carPosition.getPosition();

            if (position > maxPosition) {
                maxPosition = position;
                names.clear();
                names.add(carPosition.getName());
                continue;
            }

            if (position == maxPosition) {
                names.add(carPosition.getName());
            }
        }

        return names;
    }
}

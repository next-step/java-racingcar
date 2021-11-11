package domain;

import java.util.ArrayList;
import java.util.List;

public class CarRaceGroup {
    private static final String POSITION_COUNT_ERROR_MESSAGE = "error : 입력된 자동차 위지 개수는 1개(시작위치) 이거나 자동차 개수와 동일해야 합니다.";
    private static final int START_POSITION = 0;
    private static final String DEFAULT_NUMBER = "0";
    private static final int DEFAULT_POSITION_COUNT = 1;
    private final List<CarRace> carRaceGroup;

    public CarRaceGroup(CarNames names) {
        this(names, new CarPosition(DEFAULT_NUMBER));
    }

    public CarRaceGroup(CarNames names, CarPosition carPosition) {
        checkPosition(names, carPosition);
        this.carRaceGroup = createCarRaceGroup(names, carPosition);
    }

    private void checkPosition(CarNames names, CarPosition carPositionCount) {
        int positionSize = carPositionCount.size();
        if (positionSize != DEFAULT_POSITION_COUNT && positionSize < names.count()) {
            throw new IllegalArgumentException(POSITION_COUNT_ERROR_MESSAGE);
        }
    }

    private List<CarRace> createCarRaceGroup(CarNames names, CarPosition carPosition) {
        List<CarRace> carRaceGroup = new ArrayList<>();

        int carNameSize = names.count();
        int carPositionSize = carPosition.size();
        for (int i = 0; i < carNameSize; i++) {
            carRaceGroup.add(new CarRace(names.name(i), position(i, carPositionSize)));
        }

        return carRaceGroup;
    }

    private int position(int index, int count) {
        if (count == DEFAULT_POSITION_COUNT) {
            return START_POSITION;
        }
        return index;
    }

    public void positionPlus(int index) {
        carRaceGroup.get(index).positionAdd(Driving.driving());
    }

    public int size() {
        return carRaceGroup.size();
    }

    public int carPosition(int index) {
        return carRaceGroup.get(index).getPosition();
    }

    public List<CarRace> getCarRaceGroup() {
        return carRaceGroup;
    }

    public String name(int index) {
        return carRaceGroup.get(index).getCarName();
    }

    public int position(int index) {
        return carRaceGroup.get(index).getPosition();
    }

}

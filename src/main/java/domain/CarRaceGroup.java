package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRaceGroup {
    private static final int MOVING_STANDARD_NUMBER = 4;
    private static final int STOP_NUMBER = 0;
    private static final int MOVING_NUMBER = 1;
    private static final int POSITION_START_NUMBER = 0;
    private static final int BEFORE_INDEX_ZERO = 0;
    private static final String MAX_NUMBER_ERROR_MESSAGE = "error : MAX 값을 찾을수 없습니다.";
    private static final String COMMA = ", ";
    private final List<CarRace> carRaceGroup;

    public CarRaceGroup(CarGroup carGroup, CarRaceCount carRaceCount) {
        this.carRaceGroup = Collections.unmodifiableList(startCarRace(carGroup, carRaceCount));
    }

    private List<CarRace> startCarRace(CarGroup carGroup, CarRaceCount carRaceCount) {
        List<CarRace> carRaceGroup = new ArrayList<>();
        int loopNumber = carGroup.size() * carRaceCount.count();
        for (int i = 0; i < loopNumber; i++) {
            carRaceGroup.add(CarRaceResult(i, carGroup, carRaceGroup));
        }

        return carRaceGroup;
    }

    private CarRace CarRaceResult(int index, CarGroup carGroup, List<CarRace> carRaceGroup) {
        int carIndex = carGroupIndex(index, carGroup.size());
        int beforeIndex = index - carGroup.size();
        int beforePosition = beforePosition(beforeIndex, carRaceGroup);
        int afterPosition = afterPosition(beforeIndex, carRaceGroup);
        if (beforePosition == afterPosition && beforeIndex >= BEFORE_INDEX_ZERO) {
            return carRaceGroup.get(beforeIndex);
        }

        return new CarRace(carGroup.findCarName(carIndex), afterPosition);
    }

    private int carGroupIndex(int index, int carGroupSize) {
        if (index < carGroupSize) {
            return index;
        }
        return index % carGroupSize;
    }

    private int beforePosition(int beforeIndex, List<CarRace> carRaceGroup) {
        if (beforeIndex >= 0) {
            return carRaceGroup.get(beforeIndex).getPosition();
        }
        return POSITION_START_NUMBER;
    }

    private int afterPosition(int beforeIndex, List<CarRace> carRaceGroup) {
        if (beforeIndex >= 0) {
            return carRaceGroup.get(beforeIndex).getPosition() + driving();
        }

        return driving();
    }

    private int driving() {
        if (Driving.drive() >= MOVING_STANDARD_NUMBER) {
            return MOVING_NUMBER;
        }
        return STOP_NUMBER;
    }

    public int size() {
        return carRaceGroup.size();
    }

    public String carName(int index) {
        return carRaceGroup.get(index).getCar();
    }

    public int carPosition(int index) {
        return carRaceGroup.get(index).getPosition();
    }

    public String winner() {
        int max = positionMax();

        return this.carRaceGroup
                .stream()
                .filter(i -> i.getPosition() == max)
                .map(i -> i.getCar())
                .distinct()
                .sorted()
                .collect(Collectors.joining(COMMA));
    }

    private int positionMax() {
        return this.carRaceGroup
                .stream()
                .mapToInt(i -> i.getPosition())
                .max()
                .orElseThrow(() -> new IllegalArgumentException(MAX_NUMBER_ERROR_MESSAGE));
    }

}

package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRaceGroup {
    private static final String MAX_NUMBER_ERROR_MESSAGE = "error : MAX 값을 찾을수 없습니다.";
    private static final String COMMA = ", ";
    private final List<CarRace> carRaceGroup;

    public CarRaceGroup(CarNames names) {
        this(createCarRaceGroup(names));
    }

    public CarRaceGroup(List<CarRace> carRaceGroup) {
        this.carRaceGroup = Collections.unmodifiableList(carRaceGroup);
    }

    private static List<CarRace> createCarRaceGroup(CarNames names) {
        List<CarRace> carRaceGroup = new ArrayList<>();

        int nameCount = names.count();
        for (int i = 0; i < nameCount; i++) {
            carRaceGroup.add(new CarRace(new CarName(names.name(i)), new CarPosition(0)));
        }

        return carRaceGroup;
    }

    public CarRaceGroup racing() {
        List<CarRace> carRaceArray = new ArrayList<>();
        for (CarRace carRace : carRaceGroup) {
            carRaceArray.add(carRace.positionPlus(Driving.driving()));
        }
        return new CarRaceGroup(carRaceArray);
    }

    public int size() {
        return carRaceGroup.size();
    }

    public String name(int index) {
        return carRaceGroup.get(index).name();
    }

    public int position(int index) {
        return carRaceGroup.get(index).position();
    }

    public String findWinner() {
        int max = positionMax();

        return carRaceGroup
                .stream()
                .filter(i -> i.position() == max)
                .map(i -> i.name())
                .sorted()
                .collect(Collectors.joining(COMMA));
    }

    public int positionMax() {
        return carRaceGroup.stream()
                .mapToInt(i -> i.position())
                .max()
                .orElseThrow(() -> new IllegalArgumentException(MAX_NUMBER_ERROR_MESSAGE));
    }
}

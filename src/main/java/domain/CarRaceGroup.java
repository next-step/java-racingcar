package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRaceGroup {
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

}

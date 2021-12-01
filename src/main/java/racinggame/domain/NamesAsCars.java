package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NamesAsCars implements Cars {
    private final Names names;

    public NamesAsCars(Names names) {
        this.names = names;
    }

    @Override
    public List<Car> cars() {
        List<Car> cars = new ArrayList<>();
        for (Name name : names.names()) {
            cars.add(new Car(name.name()));
        }
        return Collections.unmodifiableList(cars);
    }
}

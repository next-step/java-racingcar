package car.ui;

import car.domain.Name;

public class Winner {
    private Name name;

    public Winner(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name.getName();
    }
}

package me.namuhuchutong.step4;

import java.util.List;

public class CarNames {

    private final List<String> names;

    public static CarNames from(List<String> names) {
        return new CarNames(names);
    }

    private CarNames(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return List.copyOf(names);
    }

    public int getNumberOfNames() {
        return this.names.size();
    }
}

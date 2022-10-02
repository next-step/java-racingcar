package step4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    private List<String> names = new ArrayList<>();
    private int times;

    public Car(String[] names, int times) {

        for(String name : names) {
            Validation.checkName(name);
        }

        this.names = Arrays.asList(names);
        this.times = times;
    }

    public List<String> getNames() {
        return names;
    }

    public int getTimes() {
        return times;
    }
}

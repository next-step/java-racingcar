package step4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names = new ArrayList<>();

    public void addNames(String namesStr) {
        String[] nameList = namesStr.split(",");

        Arrays.stream(nameList).forEach(nameStr -> {
            Name name = new Name(nameStr);
            names.add(name);
        });
    }

    public List<Name> getNames() {
        return names;
    }

    public List<Car> makeCarListWithDefaultPosition() {
        return names.stream().map(name -> Car.createWithDefaultPosition(name))
                .collect(Collectors.toList());
    }

}

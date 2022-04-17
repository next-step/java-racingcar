package step3.model;

import java.util.ArrayList;
import java.util.List;

public class Names {

    private static final String DELIMITER = ",";

    private List<Name> eachNames;

    public Names(String input) {
        String[] splits = input.split(DELIMITER);
        this.eachNames = initNames(splits);
    }

    private List<Name> initNames(String[] splits) {
        List<Name> names = new ArrayList<>();
        for (String split : splits) {
            names.add(new Name(split));
        }
        return names;
    }

    public List<Name> getEachNames() {
        return eachNames;
    }
}

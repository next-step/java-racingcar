package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Names {

    private final List<Name> names = new ArrayList<>();

    public void addNames(String namesStr) {
        String[] nameList = namesStr.split(",");

        Arrays.stream(nameList).forEach(nameStr -> {
            Name name = new Name(nameStr);
            addName(name);
        });
    }

    private void addName(Name name){
        names.add(name);
    }

    public List<Name> getNames() {
        return names;
    }
}

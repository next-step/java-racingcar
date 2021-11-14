package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Names {
    private static final String CAR_NAME_SEPARATORS = ",";

    private final List<Name> names;

    public static Names from(String text) throws Exception {
        String[] nameArr = text.split(CAR_NAME_SEPARATORS);
        List<Name> names = new ArrayList<>();
        for (String name : nameArr) {
            names.add(new Name(name));
        }
        return new Names(names);
    }

    private Names(List<Name> names) {
        this.names = names;
    }

    public List<Name> getNames() {
        return names;
    }

    public String printNames() {
        StringBuilder printName = new StringBuilder();
        for (Name name : names) {
            printName.append(name.getName());
            printName.append(",");
        }
        return printName.substring(0, printName.length() - 1);
    }
}

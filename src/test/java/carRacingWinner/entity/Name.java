package carRacingWinner.entity;

import java.util.ArrayList;
import java.util.List;

public class Name {
    List<String> name;
    static final String division = ",";

    public Name(String input) {
        this.name = List.of(input.split(division));
    }

    public List<String> getName() {
        return name;
    }
}

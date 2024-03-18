package carRacingWinner.entity;

import java.util.ArrayList;
import java.util.List;

public class Name {
    List<String> name;
    static final String division = ",";

    private void createName() {
        this.name = new ArrayList<>();
    }

    public Name(String input) {
        createName();
        name = List.of(input.split(division));
    }

    public List<String> getName() {
        return name;
    }
}

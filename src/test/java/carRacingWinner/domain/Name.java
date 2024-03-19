package carRacingWinner.domain;

import java.util.ArrayList;
import java.util.List;

public class Name {
    private List<String> name;
    private static final String division = ",";

    public Name() {
        createName();
    }

    public Name(String word) {
        make(word);
    }

    private void createName() {
        this.name = new ArrayList<>();
    }

    public void make(String input) {
        createName();
        this.name = List.of(input.split(division));
    }

    public List<String> getName() {
        return name;
    }
}

package carRacing.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {
    private final String unparsedNameOfCars;
    private final int numberOfRace;

    public UserInput(String nameOfCars, int numberOfRace) {
        if (!isNamesValid(nameOfCars)) throw new IllegalArgumentException();
        this.unparsedNameOfCars = nameOfCars;
        this.numberOfRace = numberOfRace;
    }

    public String getUnparsedNameOfCars() {
        return unparsedNameOfCars;
    }

    public int getNumberOfRace() {
        return numberOfRace;
    }

    public boolean isNamesValid(String unparsedNameOfCars) {
        List<String> nameOfCars = Arrays.asList(unparsedNameOfCars.split(","));
        List<String> validNameList = nameOfCars.stream()
                .filter(name -> name.length() <= 5)
                .collect(Collectors.toList());
        return nameOfCars.size() == validNameList.size();
    }

    public List<String> getParsedNameOfCars() {
        return Arrays.asList(this.getUnparsedNameOfCars()
                .split(","));
    }
}

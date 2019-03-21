package racing.dto;

import java.util.ArrayList;
import java.util.List;

public class UserInputValueObject {
    private int inputTime;
    private List<String> inputCarNames;

    public UserInputValueObject(final String inputCarNames, final int inputTime) {
        String[] cars = inputCarNames.split(",");
        this.inputCarNames = new ArrayList<String>();

        for (String car : cars) {
            this.inputCarNames.add(car);
        }

        this.inputTime = inputTime;
    }

    public List<String> getInputCarNames() {
        return this.inputCarNames;
    }

    public int getInputCarTime() {
        return this.inputTime;
    }

}

package racingcar;

import lombok.Data;

@Data
public class UserInput {
    private String numOfCars;
    private String numOfTries;

    public UserInput(String numOfCars, String numOfTries) {
        this.numOfCars = numOfCars;
        this.numOfTries = numOfTries;
    }
}

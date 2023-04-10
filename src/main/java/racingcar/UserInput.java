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

    public int getNumOfTriesByInt() {
        return Integer.parseInt(numOfTries);
    }

    public int getNumOfCarsByInt() {
        return Integer.parseInt(numOfCars);
    }
}

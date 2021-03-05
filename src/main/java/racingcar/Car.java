package racingcar;

public class Car {

    private String state;

    public Car(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void updateByRandom(int randomNumber) {
        if (randomNumber >= 4) {
            state += "-";
        }
    }
}

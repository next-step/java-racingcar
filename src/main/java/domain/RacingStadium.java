package domain;

import domain.Car;

public class RacingStadium {

    private int time;
    private Car[] cars;

    public int getTime() {
        return this.time;
    }

    public Car[] getCars() {
        return this.cars;
    }

    public Car getCar(int index){
        return this.cars[index];
    }

    public RacingStadium(String[] carNames, int time) {
        this.time = time;

        this.cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(0, carNames[i]);
        }
    }
}

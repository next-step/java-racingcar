package step3;

public class Car {

    private CarEngine carEngine;
    private String currentLocation;

    public Car(CarEngine carEngine) {
        this.carEngine = carEngine;
        currentLocation = "";
    }

    public void move() {
        if (!carEngine.canGo(NumberGenerator.createRandomNumbers())) {
            return;
        }

        currentLocation += "-";
    }

    public void showNowLocation() {
        System.out.println(currentLocation);
    }
}

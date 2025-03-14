
public class CarRaceGame {
    private static Car car = new Car(0);

    public static void main(String[] args) {
        int tryNumber = InputView.inputTryNumber();
        for (int i=0; i<tryNumber; i++) {
            car.randomGo();
            car.printLocation();
        }
    }
}

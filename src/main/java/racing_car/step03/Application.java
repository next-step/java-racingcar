package racing_car.step03;

public class Application {
    public static void main(String[] args) {
        int carCount = InputView.carCount();
        int tryCount = InputView.tryCount();
        System.out.println(carCount+" "+tryCount);
    }
}

public class CarRacing {
    public static void executeGame(InputView input) {
        final Cars cars = Cars.createCars(input.carCount);
        for (int i = 0; i < input.gameCount; i++) {
            cars.play();
            ResultView.printResult(cars);
        }
    }
}

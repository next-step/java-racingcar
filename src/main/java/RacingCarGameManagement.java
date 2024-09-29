public class RacingCarGameManagement {
    private RacingCar[] cars;
    private int games;

    public RacingCarGameManagement(int cars, int games) {
        this.cars = new RacingCar[cars];
        this.games = games;
        for (int i = 0; i < this.cars.length; i++) {
            this.cars[i] = new RacingCar();
        }
    }

    public RacingCar[] getCars() {
        return cars;
    }

    public int getGames() {
        return games;
    }

    public void start() {
        ResultView.printIntroductionResult();
        while (this.games > 0) {
            games--;

            moveCars();
            ResultView.printResult(this.cars);
        }
    }

    private void moveCars() {
        for (RacingCar car : this.cars) {
            car.move(RandomUtil.getInt());
        }
    }

    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        int numberOfGames = InputView.getNumberOfGames();
        RacingCarGameManagement carGameManagement = new RacingCarGameManagement(numberOfCars, numberOfGames);
        carGameManagement.start();
    }
}

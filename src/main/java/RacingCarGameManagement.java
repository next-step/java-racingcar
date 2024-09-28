public class RacingCarGameManagement {
    private RacingCar[] cars;
    private int games;

    public RacingCarGameManagement(int cars, int games) {
        this.cars = new RacingCar[cars];
        this.games = games;
    }

    public RacingCar[] getCars() {
        return cars;
    }

    public int getGames() {
        return games;
    }

    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        System.out.println(numberOfCars);
        int numberOfGames = InputView.getNumberOfGames();
        System.out.println(numberOfGames);
    }
}

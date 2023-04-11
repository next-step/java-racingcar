public class RacingGame {

    private Cars cars;
    private Records records;

    public RacingGame(String[] nameOfCars) {
        this.cars = Cars.make(nameOfCars);
        this.records = new Records();
    }

    public Records start(int trial) {
        for (int i = 0; i < trial; i++) {
            cars.move();
            records.add(cars);
        }

        records.addWinners(cars);

        return records;
    }
}

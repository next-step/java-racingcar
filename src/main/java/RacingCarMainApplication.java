public class RacingCarMainApplication {
    public static void main(String[] args) {
        String names = Printer.askNameOfCars();
        int tryCount = Printer.askNumberOfTry();

        RacingCar racingCar = new RacingCar(names);
        MovePolicy randomMove = new RandomMove();

        Cars racedCars = null;

        Printer.printResultTitle();

        for (int i = 0; i < tryCount; i++) {
            racedCars = racingCar.move(randomMove);
            Printer.printResult(racedCars);
        }

        Printer.printWinner(racedCars);
    }
}

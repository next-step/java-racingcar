package step3;

public class CarRacingApplication {
    public static void main(String[] args) {
        OutputView.printNumberOfCars();
        int numberOfCars = InputView.getInput();
        OutputView.printNumberOfRounds();
        int numberOfRounds = InputView.getInput();
        System.out.println();
        Cars cars = new Cars(numberOfCars,new RandomMoveStrategy());
        for(int i=0; i<numberOfRounds; i++){
            cars.move();
            OutputView.printCarRacing(cars);
        }
    }
}

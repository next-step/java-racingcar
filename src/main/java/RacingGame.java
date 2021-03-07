import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class RacingGame {

    private Scanner scanner;

    RacingGame () {
        scanner = new Scanner(System.in);
    }

    public void end() {
        if (scanner != null) scanner.close();
    }

    private int inputIntArgument(String description){
        System.out.println(description);
        return scanner.nextInt();
    }

    private void carsAdvance(List<Car> cars){
        for (int i = 0; i < cars.size(); i++) {
            raceCar(cars.get(i));
        }
    }

    private void raceCar(Car car) {
        car.advance();
        String progress = Stream.generate(()-> "-")
                .limit(car.getNumberOfAdvance() == 0 ? 1 : car.getNumberOfAdvance())
                .reduce((a, b) -> a + b).get();
        System.out.println(progress);
    }

    private void outputResult(List<Car> cars, int numberOfAttempts){
        for (int i = 0; i < numberOfAttempts; i++) {
            carsAdvance(cars);
            System.out.print("\n");
        }
    }

    public void start() {
        try {
            int numberOfCars = inputIntArgument("자동차 대수는 몇 대 인가요?");
            int numberOfAttempts = inputIntArgument("시도할 회수는 몇 회 인가요?");
            List<Car> cars = new CarFactory(numberOfCars).generateCars();

            outputResult(cars, numberOfAttempts);

        } catch (Exception exception) {
            exception.printStackTrace();

        } finally {
            end();
        }
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.start();
    }

}

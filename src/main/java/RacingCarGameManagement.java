import java.util.ArrayList;
import java.util.List;

public class RacingCarGameManagement {
    private List<RacingCar> cars;
    private int games;
    private RandomNumberGenerator randomNumberGenerator;

    public RacingCarGameManagement(
            int cars,
            int games,
            RandomNumberGenerator randomNumberGenerator
    ) {
        this.cars = new ArrayList<>(cars);
        this.games = games;
        this.randomNumberGenerator = randomNumberGenerator;
        for (int i = 0; i < cars; i++) {
            this.cars.add(new RacingCar());
        }
    }

    public RacingCarGameManagement(
            String[] names,
            int games,
            RandomNumberGenerator randomNumberGenerator
    ) {
        this.cars = new ArrayList<>(names.length);
        this.games = games;
        this.randomNumberGenerator = randomNumberGenerator;
        for (int i = 0; i < names.length; i++) {
            this.cars.add(new RacingCar(names[i]));
        }
    }

    public List<RacingCar> getCars() {
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
            car.move(this.randomNumberGenerator.generate());
        }
    }

    public static void main(String[] args) {
        String[] split = InputView.getNames();
        int numberOfGames = InputView.getNumberOfGames();
        RandomUtil randomUtil = new RandomUtil();

        RacingCarGameManagement carGameManagement = new RacingCarGameManagement(split, numberOfGames, randomUtil);
        carGameManagement.start();
    }
}

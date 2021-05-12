import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGameController {
    static RacingCarGameView view = new RacingCarGameView();
    static Random random = new Random();

    static final String SEPARATOR = ",";

    public void startGame() {
        String carNames = view.inputCarNames();

        int roundNumber = view.inputRoundNumber();
        checkRoundNumber(roundNumber);

        String[] splitCarNames = splitBySeparator(carNames);

        List<RacingCar> racingCars = makeRacingCarsWithCarNames(splitCarNames);
        runGame(racingCars, roundNumber);

        int maxScore = getMaxScore(racingCars);
        String winners = getWinners(racingCars, maxScore);
        view.outputWinners(winners);
    }

    public void checkRoundNumber(int roundNumber) {
        if (roundNumber < 0) {
            throw new IllegalArgumentException("게임을 시도할 횟수는 0 이상이어야 한다.");
        }
    }

    public String[] splitBySeparator(String carNames) {
        return carNames.split(SEPARATOR);
    }

    public List<RacingCar> makeRacingCarsWithCarNames(String[] carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return racingCars;
    }

    public void runGame(List<RacingCar> cars, int roundNumber) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < roundNumber; i++) {
            startRound(cars);
            outputRound(cars);
        }
    }

    public void startRound(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            int randomNumber = random.nextInt(10);
            car.move(randomNumber);
        }
    }

    public void outputRound(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(car.getName() + " : " + bar(car.getStep()));
        }
        System.out.println();
    }

    public String bar(int step) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < step; i++) {
            bar.append("-");
        }
        return bar.toString();
    }

    public int getMaxScore(List<RacingCar> cars) {
        int maxScore = 0;
        for (RacingCar car : cars) {
            if (maxScore < car.getStep()) {
                maxScore = car.getStep();
            }
        }
        return maxScore;
    }

    public String getWinners(List<RacingCar> cars, int maxScore) {
        String winners = "";
        for (RacingCar car : cars) {
            if (car.getStep() == maxScore) {
                winners += " " + car.getName() + ",";
            }
        }
        winners = winners.substring(0, winners.length() - 1);
        return winners;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarController {

    RacingCarView view = new RacingCarView();

    Random random = new Random();

    public void startGame() {
        String carNamesString = view.inputCarNames();

        int roundNumber = view.inputRoundNumber();

        String[] carNames = splitBySeparator(carNamesString);

        List<RacingCar> racingCars = getRacingCars(carNames);

        startGame(racingCars, roundNumber);

        int maxScore = getMaxScore(racingCars);
        String winners = getWinners(racingCars, maxScore);

        view.outputWinners(winners);
    }

    public String[] splitBySeparator(String carNames) {
        String separator = ",";
        return carNames.split(separator);
    }

    public List<RacingCar> getRacingCars(String[] carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return racingCars;
    }

    public void startGame(List<RacingCar> cars, int roundNumber) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < roundNumber; i++) {
            startRound(cars, roundNumber);
            outputRound(cars);
        }
    }

    public void startRound(List<RacingCar> cars, int roundNumber) {
        for (RacingCar car : cars) {
            int randomNumber = random.nextInt(10);
            car.move(randomNumber);
        }
    }

    public void outputRound(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(car.getName() + " : " + bar(car.getStep()));
        }
        System.out.println("");
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

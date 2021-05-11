import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class RacingCarController {

    Scanner scanner = new Scanner(System.in);

    Random random = new Random();

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int inputRoundNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }

    public void game(String input, int roundNumber) {
        String[] carNames = splitBySeparator(input);
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        run(racingCars, roundNumber);
    }

    private String[] splitBySeparator(String carNames) {
        String separator = ",";
        return carNames.split(separator);
    }

    public void run(List<RacingCar> cars, int roundNumber) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < roundNumber; i++) {
            for (RacingCar car : cars) {
                int randomNumber = random.nextInt(10);
                car.move(randomNumber);
            }
            outputResult(cars);
            System.out.println("");
        }
        outputWinners(cars);
    }

    private void outputResult(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(car.getName() + " : " + bar(car.getStep()));
        }
    }

    private String bar(int step) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < step; i++) {
            bar.append("-");
        }
        return bar.toString();
    }

    private void outputWinners(List<RacingCar> cars) {
        System.out.print("최종 우승자:");
        int maxScore = getMaxScore(cars);
        System.out.println(getWinnerList(cars, maxScore));
    }

    private int getMaxScore(List<RacingCar> cars) {
        int maxScore = 0;
        for (RacingCar car : cars) {
            if (maxScore < car.getStep()) {
                maxScore = car.getStep();
            }
        }
        return maxScore;
    }

    private String getWinnerList(List<RacingCar> cars, int maxScore) {
        String winnerList = "";
        for (RacingCar car : cars) {
            if (car.getStep() == maxScore) {
                winnerList += " " + car.getName() + ",";
            }
        }
        winnerList = winnerList.substring(0, winnerList.length() - 1);
        return winnerList;
    }
}

package step3.racingcar;

import java.util.Scanner;

public class RacingCarGame {

    int randomSeed;
    int numberOfCars;
    int numberOfRounds;
    RacingCar[] cars;
    RacingCarGameRound[] rounds;

    public RacingCarGame(int numberOfCars, int numberOfRounds, int randomSeed) {
        this.numberOfCars = numberOfCars;
        this.numberOfRounds = numberOfRounds;
        this.randomSeed = randomSeed;
    }

    public RacingCarGame(int numberOfCars, int numberOfRounds) {
        this.numberOfCars = numberOfCars;
        this.numberOfRounds = numberOfRounds;
    }

    public RacingCarGame() {
        this.numberOfCars = getNumberOfCars();
        this.numberOfRounds = getNumberOfRounds();
    }

    public static int getNumberOfCars() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("자동차 대수는 몇 대 인가요? - ");
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
        }
        throw new RacingCarGameException("숫자를 입력받는데 실패했습니다.");
    }

    public static int getNumberOfRounds() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("시도할 회수는 몇 회 인가요? - ");
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
        }
        throw new RacingCarGameException("숫자를 입력받는데 실패했습니다.");
    }

    public void start() {
        for (int i = 0; i < numberOfRounds; i++) {
            rounds[i].start();
            rounds[i].showResult();
        }
    }

    public void ready() {
        this.cars = new RacingCar[this.numberOfCars];
        for (int i = 0; i < numberOfCars; i++) {
            int no = i + 1;
            cars[i] = new RacingCar(no);
        }

        this.rounds = new RacingCarGameRound[this.numberOfRounds];
        for (int i = 0; i < numberOfRounds; i++) {
            int no = i + 1;
            rounds[i] = new RacingCarGameRound(no, cars);
        }
    }

    public int carStatus(int no) {
        return cars[no - 1].currentProgress();
    }

    public String settings() {
        return String.format("numberOfCars: %d, numberOfRounds: %d", numberOfCars, numberOfRounds);
    }

}

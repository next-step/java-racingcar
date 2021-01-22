package racingcar;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGameController {

    private final int LOWER_BOUND_MOVE = 4;

    private final ArrayList<RacingCar> cars;
    private final List<String> winners;
    private final Scanner sc = new Scanner(System.in);
    private int numberOfRound;
    private final Random rand;

    public RacingGameController() {
        cars = new ArrayList<>();
        winners = new ArrayList<>();
        rand = new Random();
    }

    public ArrayList<RacingCar> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        return winners;
    }

    public void start() {

        String CarsName = getCarsName();
        setCarsName(CarsName);
        getRound();
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfRound; i++) {
            playRound();
        }
        int maxStatus = getMaxStatusAmongPlayers();
        findWinnerWithMaxStatus(maxStatus);
    }

    public String getCarsName() {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String CarsName = null;
        boolean isProperInput = false;
        while (!isProperInput) {
            CarsName = sc.nextLine();
            isProperInput = InputValidator.checkCarsNameInput(CarsName);
        }
        return CarsName;
    }

    public void setCarsName(String input) {

        String[] inputs = input.split(",");
        for (String s : inputs) {
            cars.add(new RacingCar(s));
        }
    }

    private void getRound() throws IllegalArgumentException {

        System.out.println("시도할 횟수는 몇 회인가요?");

        numberOfRound = sc.nextInt();
    }

    public void playRound() {

        for (RacingCar car : cars) {
            moveEachCar(car);
        }
        RacingGamePrinter.printAllCarStatus(cars);

    }

    public void moveEachCar(RacingCar racingCar) {

        if (getRandomNumber() >= LOWER_BOUND_MOVE) {
            racingCar.movingForward();
        }
    }

    private int getRandomNumber() {

        return rand.nextInt(10);
    }




    public void findWinnerWithMaxStatus(int maxStatus) {

        for (int i = 0; i < cars.size(); i++) {
            findEachWinner(i, maxStatus);
        }
        RacingGamePrinter.printWinners(winners);
    }

    public int getMaxStatusAmongPlayers() {

        int maxStatus = 0;
        for (RacingCar car : cars) {
            maxStatus = Math.max(maxStatus, car.getStatus());
        }
        return maxStatus;
    }

    private void findEachWinner(int index, int maxStatus) {

        if (cars.get(index).getStatus() == maxStatus) {
            winners.add(cars.get(index).getName());
        }
    }

}

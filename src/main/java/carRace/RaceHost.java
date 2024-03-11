package carRace;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RaceHost {

    private static final int WAIT_RACE_TIME = 10;

    private int carMount;

    private int raceTryNumber;

    private ExecutorService executorService = Executors.newCachedThreadPool();

    private final Scanner scanner = new Scanner(System.in);

    public RaceHost(int carMount, int raceTryNumber) {
        this.carMount = carMount;
        this.raceTryNumber = raceTryNumber;
    }

    public int carMount(){
        return this.carMount;
    }

    public void inputRaceInformation(){
        System.out.println("자동차 대수는 몇 대 인가요?\n");
        carMount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요\n");
        raceTryNumber = scanner.nextInt();
    }

    public void playGame(List<Car> carList){
        for (int gameCount = 0; gameCount < raceTryNumber; gameCount++){
            moveCar(carList);
        }
        finishGame();
    }

    private void moveCar(List<Car> carList) {
        for (int carNumber = 0; carNumber < carMount; carNumber++){
            executorService.execute(carList.get(carNumber));
        }
    }
    private void finishGame() {
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            waitRace();
        }
    }

    private static void waitRace() {
        try {
            Thread.sleep(WAIT_RACE_TIME);
        } catch (InterruptedException e) {
            System.out.println("경기가 비정상적으로 종료되지 않고 있습니다. 강제종료: CTRL + C");
        }
    }

    public void printRaceInfo(List<Car> carList) {
        carList.forEach(car -> car.printRaceResult());
    }
}

package step3_RacingCar_Competition;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarCompetition {
    private final boolean GO = true;
    private final boolean STOP = false;

    public void startRacing() {
        insertRacingCarData();
        RacingCarInfo racingCarInfo = insertRacingCarData();
        int totalNumberOfCars = racingCarInfo.totalNumberOfCars();
        int totalMovingCount = racingCarInfo.totalMovingCount();
        ArrayList<ArrayList<Integer>> randomMovingData = randomCarMovingData(totalNumberOfCars, totalMovingCount);
        recordRacingCarData(randomMovingData, racingCarInfo);

    }


    private RacingCarInfo insertRacingCarData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int movingTryCount = scanner.nextInt();

        return new RacingCarInfo(numberOfCars, movingTryCount);
    }

    /**
     * 이중 ArrayList로 0~9 랜덤값 채워 반환하는 메서드
     */
    private ArrayList<ArrayList<Integer>> randomCarMovingData(int totalNumberOfCars, int totalMovingCount) {
        ArrayList<ArrayList<Integer>> randomData = IntStream.range(0, totalNumberOfCars)
                .mapToObj(numberOfCars -> IntStream.range(0, totalMovingCount)
                        .mapToObj(movingTryCount -> randomNumber())
                        .collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));
        return randomData;
    }

    /**
     * 랜덤 데이터로 차의 이동 기록하는 메서드
     */
    public void recordRacingCarData(ArrayList<ArrayList<Integer>> randomMovingData, RacingCarInfo racingCarInfo) {
        int totalNumberOfCars = racingCarInfo.totalNumberOfCars();
        int totalMovingCount = racingCarInfo.totalMovingCount();

        IntStream.range(0, totalMovingCount).forEachOrdered(movingTryCount -> {
            IntStream.range(0, totalNumberOfCars).forEachOrdered(numberOfCars -> {
                if (GO == moveStopDecision(randomMovingData.get(numberOfCars).get(movingTryCount))) {
                    racingCarInfo.recordGoInRacingCarData(numberOfCars);
                }
            });
            printCurrentCarMovement(racingCarInfo, totalNumberOfCars);
        });
    }

    /**
     * 현재 시도회수까지 출력하는 메서드
     */
    public void printCurrentCarMovement(RacingCarInfo racingCarInfo, int totalNumberOfCars) {
        IntStream.range(0, totalNumberOfCars)
                .mapToObj(racingCarInfo::findRacingCarData)
                .forEachOrdered(System.out::println);
        System.out.println("\n");
    }

    /**
     * TODO private로 하고 싶은데 테스트하자니 지양됨.
     * 그렇다고 public으로 하기는 싫은데 고민.
     */
    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public boolean moveStopDecision(int randomNumber) {
        return randomNumber >= 4 ? GO : STOP;
    }

}

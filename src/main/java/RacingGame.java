import java.util.Random;

public class RacingGame {

    /**
     * Random 인스턴스를 재활용하기 위해 static 변수로 등록
     */
    private static final Random RANDOM_SINGLETON_INSTANCE = new Random();

    /**
     * 자동차가 전진하는 조건의 기준값
     */
    public static final int MIN_VALUE_TO_MOVE_CAR = 4;

    // 콘솔 입력(Scanner)을 통한 게임 진행 테스트
    /*
    public static void main(String[] args) {
        playRacingGameByUserInput();
    }
    */

    /**
     * 요구사항대로 Scanner를 이용하여 자동차 경주 게임을 실행하는 메소드
     */
    public static void playRacingGameByUserInput() {
        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();
        playRacingGame(carCount, tryCount);
    }

    /**
     * 자동자 경주 게임의 실제 동작 로직을 구현드 메소드
     *
     * @param carCount 자동차 대수
     * @param tryCount 시도 횟수
     */
    public static void playRacingGame(int carCount, int tryCount) {
        int[] cars = new int[carCount];
        moveCarsByTryCount(cars, tryCount);
    }

    /**
     * 시도 횟수 만큼 자동차들을 움직이는 기능을 구현한 메소드
     *
     * @param cars     자동차 배열
     * @param tryCount 시도 횟수
     */
    public static void moveCarsByTryCount(int[] cars, int tryCount) {
        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            ResultView.printCarMovements(cars);
        }
    }

    /**
     * 자동차 배열을 전달받아 각 자동차 별로 움직이는 기능을 구현한 메소드
     *
     * @param cars 자동차 배열
     */
    public static void moveCars(int[] cars) {
        for (int j = 0; j < cars.length; j++) {
            moveCarByRandomValue(cars, j, MIN_VALUE_TO_MOVE_CAR);
        }
    }

    /**
     * 자동차 배열에 속한 자동차 별로 랜덤값이 기준값 이상인 경우 움직이는 기능을 구현한 메소드
     *
     * @param cars 자동차 배열
     * @param index 자동차 index
     * @param minValueToMoveCar 자동차가 움직이는 기준값
     */
    public static void moveCarByRandomValue(int[] cars, int index, int minValueToMoveCar) {
        if (getRandomIntBound10() >= minValueToMoveCar) {
            cars[index]++;
        }
    }

    /**
     * 10 미만의 integer 를 Random 하게 리턴하는 메소드
     * @return
     */
    public static int getRandomIntBound10() {
        return RANDOM_SINGLETON_INSTANCE.nextInt(10);
    }

}
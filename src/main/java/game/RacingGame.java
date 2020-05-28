package game;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    public final Integer POINT_FORWARD = POINT;

    public final static Integer POINT = 4;

    /**
     * 자동차 경주 게임
     *
     * @param carCount
     * @param count
     */
    public void racing(int carCount, int count) {

        for (int i = 0; i < count; i++) {
            ResultView.create().racingResultView(move(carCount, count));
        }
    }

    /**
     * n개 자동차 경주 결과
     *
     * @param carCount
     * @param count
     * @return
     */
    public int[] move(int carCount, int count) {

        int[] carPositions = new int[carCount];

        for (int i = 0; i < carCount; i++) {
            carPositions[i] = getMovePoint(count);
        }

        return carPositions;
    }

    /**
     * 시도횟수에 대한 이동 횟수 구하기
     *
     * @return
     */
    public int getMovePoint(int count) {

        int result = 0;
        for (int i = 0; i < count; i++) {
            if (!isGoForward(getPoint())) {
                continue;
            }
            result++;
        }
        return result;
    }

    /**
     * 포인트 계산
     *
     * @return
     */
    public int getPoint() {
        return new Random().nextInt(10);
    }

    /**
     * 전진/정지 여부
     *
     * @param point
     * @return
     */
    public boolean isGoForward(int point) {
        return (point >= POINT_FORWARD) ? true : false;
    }

    /**
     * 4단계 - 자동차 경주
     * @param cars
     * @param numberOfAttempts
     */
    public void racingGameStart(List<Car> cars, int numberOfAttempts) {
        int tryCount = 0;

        for (int i = 0; i < numberOfAttempts; i++) {
            racingPlay(cars, numberOfAttempts, tryCount);
            tryCount++;
        }

        ResultRacingPlayer.create().racingResultWithPlayer(cars,numberOfAttempts);

        ResultRacingPlayer.create().printWinner(findWinner(cars));
    }

    /**
     * 자동차 경주
     * @param cars
     * @param numberOfAttempts
     * @param tryCount
     */
    private void racingPlay(List<Car> cars, int numberOfAttempts, int tryCount) {

        int movePosition = 0;

        for (Car car : cars) {
            movePosition = car.move(numberOfAttempts);
            car.setMaxPosition(movePosition);
            Position position = Position.create(tryCount, movePosition);
            car.addPosition(position);
        }

    }

    /**
     * 자동차 경주 우승자
     * @return
     */
    public List<Car> findWinner(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Integer.max(maxPosition, car.getMaxPosition());
        }

        int finalMaxPosition = maxPosition;

        List<Car> winner = cars.stream()
                .filter(car -> car.getMaxPosition() == finalMaxPosition)
                .collect(Collectors.toList());

        return winner;
    }

    public static RacingGame create() {
        return new RacingGame();
    }
}

package game;

import java.util.Random;

public class RacingGame {

    public final Integer POINT_FORWARD = POINT;

    public final static Integer POINT = 4;

    /**
     * 자동차 경주 게임
     * @param cars
     * @param count
     */
    public void racing(int cars, int count){

        for(int i = 0 ; i < count ; i++){
            ResultView.create().racingResultView(move(cars,count));
        }
    }

    /**
     * n개 자동차 경주 결과
     * @param cars
     * @param count
     * @return
     */
    public int[] move(int cars, int count) {

        int[] carPositions = new int[cars];

        for (int i = 0; i < cars; i++) {
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
        for(int i =0 ; i < count ;i++){
            if(!isGoForward(getPoint())){
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

    public static RacingGame create(){
        return new RacingGame();
    }
}

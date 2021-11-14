package study.step3;

import java.util.ArrayList;
import java.util.List;

public class SetUpCar {


    private static int MIN_INPUT_NUMBER = 1;
    private static String BLANK_STRING_VALUE = "";

    // 주행 차량 수
    private int carCount;
    // 시도 회수
    private int tryRound;

    public SetUpCar(int carCount, int tryRound) {
        validateCarCount(carCount);
        validateTryRound(tryRound);

        this.carCount = carCount;
        this.tryRound = tryRound;
    }

    /**
     * 입력 문자열 Validation 체크
     * @param carCount 주행 차량 수
     */
    private static void validateCarCount(int carCount) {
        if (MIN_INPUT_NUMBER > carCount) {
            throw new IllegalArgumentException("주행 차량 수가 1보다 작은 수 입니다.");
        }
    }

    /**
     * 입력 문자열 Validation 체크
     * @param tryRound 시도 회수
     */
    private static void validateTryRound(int tryRound) {
        if (MIN_INPUT_NUMBER > tryRound) {
            throw new IllegalArgumentException("시도 회수가 1보다 작은 수 입니다.");
        }
    }

    /**
     * 시도 횟수에 따라 차량 이동
     * @return
     */
//    public void tryRacing() {
//        for (int i = START_CAR_NUMBER; i < this.tryRound; i++){
//            Cars cars = new Cars();
////            for (Car car : carList) {
////                car.moveCar(car.tryMoveNumber());
////                System.out.println(car.getLocation());
////            }
//            System.out.println(BLANK_STRING_VALUE);
//        }
//    }
}

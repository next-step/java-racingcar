package study.step3;

import java.util.ArrayList;
import java.util.List;

public class SetUpCar {

    private static int START_CAR_NUMBER = 0;
    private static int MIN_INPUT_NUMBER = 1;
    private static String BLANK_STRING_VALUE = "";

    // 주행 차량 수
    private int carCount;
    // 시도 회수
    private int tryRound;

    private List<Car> carList;

    // 입력값 validation Check
    // (입력값이 1`MIN_INPUT_NUMBER`보다 크거나 같은 정수인지 Validation Check)
    public SetUpCar(int carCount, int tryRound) {
        this(carCount, tryRound, generateCars(carCount));
    }

    public SetUpCar(int carCount, int tryRound, List<Car> carList) {
        validateParameter(carCount);
        validateParameter(tryRound);

        this.carCount = carCount;
        this.tryRound = tryRound;
        this.carList = carList;
    }

    /**
     * 입력 문자열 Validation 체크
     * @param param 입력 문자열
     */
    private static void validateParameter(int param) {
        if (MIN_INPUT_NUMBER > param) {
            throw new IllegalArgumentException("입력 문자열이 1보다 작은 수 입니다.");
        }
    }

    /**
     * 자동차 수에 따라 Car List 생성
     * @return
     */
    private static List<Car> generateCars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = START_CAR_NUMBER; i < carCount; i++) {
            Car car = new Car(i, BLANK_STRING_VALUE);
            carList.add(car);
        }
        return carList;
    }

    /**
     * 시도 횟수에 따라 차량 이동
     * @return
     */
    public void tryRacing() {
        for (int i = START_CAR_NUMBER; i < this.tryRound; i++){
            for (Car car : carList) {
                car.moveCar(car.tryMoveNumber());
                System.out.println(car.getPosition());
            }
            System.out.println(BLANK_STRING_VALUE);
        }
    }
}

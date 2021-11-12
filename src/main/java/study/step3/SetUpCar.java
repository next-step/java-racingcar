package study.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SetUpCar {

    private static int START_CAR_NUMBER = 0;
    private static int MIN_INPUT_NUMBER = 1;
    private static String BLANK_STRING_VALUE = "";

    // 주행 차량 수
    private final int carCount;
    // 시도 회수
    private final int tryCount;

    private List<Car> carList;

    // 입력값 validation Check
    // (입력값이 1`MIN_INPUT_NUMBER`보다 크거나 같은 정수인지 Validation Check)
    public SetUpCar(String carCount, String tryCount) {

        validateParameter(carCount);
        validateParameter(tryCount);

        this.carCount = Integer.parseInt(carCount);
        this.tryCount = Integer.parseInt(tryCount);

        generateCarList();
    }

    /**
     * 입력 문자열 Validation 체크
     * @param param
     */
    private void validateParameter(String param) {
        if (Objects.isNull(param) || param.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 정상적이지 않습니다.");
        }
        if (MIN_INPUT_NUMBER > Integer.parseInt(param)) {
            throw new IllegalArgumentException("입력 문자열이 1보다 작은 수 입니다.");
        }
    }

    /**
     * 자동차 수에 따라 Car List 생성
     * @return
     */
    private void generateCarList() {
        carList = new ArrayList<>();
        for (int i = START_CAR_NUMBER; i < this.carCount; i++) {
            Car car = new Car(i, BLANK_STRING_VALUE);
            carList.add(car);
        }
    }

    /**
     * 시도 횟수에 따라 차량 이동
     * @return
     */
    public void tryRacing() {
        for (int i = START_CAR_NUMBER; i < this.tryCount; i++){
            for (Car car : carList) {
                car.move();
                System.out.println(car.getPosition());
            }
            System.out.println(BLANK_STRING_VALUE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetUpCar setUpCar = (SetUpCar) o;
        return carCount == setUpCar.carCount && tryCount == setUpCar.tryCount && Objects.equals(carList, setUpCar.carList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carCount, tryCount, carList);
    }
}

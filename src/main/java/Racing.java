import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final List<Car> carList = new ArrayList<>(); // 자동차 리스트

    private final int tryCount; // 시도 횟수

    /**
     * @param carNum
     * @param tryCount
     * 레이싱 초기화
     */
    public Racing(int carNum, int tryCount) {
        carListSetting(carNum);
        this.tryCount = tryCount;
    }

    /**
     * @param count
     * 자동차 리스트 초기화
     */
    private void carListSetting(int count) {
        for (int i = 0; i < count; i++) {
            Car car = new Car();
            carList.add(car);
        }
    }

    /**
     * 레이싱 시작
     */
    public void start() {
        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            race();
            ResultView.printRaceRound(carList);
        }
    }

    /**
     * 레이싱 점수를 저장합니다.
     */
    private void race() {
        for (Car car : carList) {
            car.move();
        }
    }

}

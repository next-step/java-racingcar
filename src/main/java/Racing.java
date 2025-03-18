import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final List<Car> carList = new ArrayList<>(); // 자동차 리스트

    private final int tryCount; // 시도 횟수

    /**
     * @param carName
     * @param tryCount
     * 레이싱 초기화
     */
    public Racing(String[] carName, int tryCount) {
        carListSetting(carName);
        this.tryCount = tryCount;
    }

    /**
     * @param carName
     * 자동차 리스트 초기화
     */
    private void carListSetting(String[] carName) {
        for (int i = 0; i < carName.length; i++) {
            Car car = new Car();
            car.changeCarName(carName[i]);
            carList.add(car);
        }
    }

    /**
     * 레이싱 시작
     */
    public void start() {
        ResultView.printExecuteResult();

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

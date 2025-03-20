import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Racing {

    private final List<Car> carList = new ArrayList<>(); // 자동차 리스트

    private final int tryCount; // 시도 횟수

    private static final List<Car> winners = new ArrayList<>(); //우승 자동차

    /**
     * @param carNames
     * @param tryCount
     * 레이싱 초기화
     */
    public Racing(List<String> carNames, int tryCount) {
        carListSetting(carNames);
        this.tryCount = tryCount;
    }

    /**
     * @param carNames
     * 자동차 리스트 초기화
     */
    private void carListSetting(List<String> carNames) {
        for (String name : carNames) {
            carList.add(new Car(name));
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

        ResultView.printWinner(findWinner());
    }

    /**
     * @return 우승자를 찾습니다.
     */
    private List<Car> findWinner() {
        int maxScore = carList.stream().mapToInt(Car::getPosition).max().orElse(0);

        return carList.stream().filter(car -> car.getPosition() == maxScore).collect(Collectors.toList());
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

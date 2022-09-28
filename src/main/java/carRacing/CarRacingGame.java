package carRacing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarRacingGame {
    private final Integer tryCount;
    private final List<Car> carEntryList = new ArrayList<>();

    private final static int RANGE_TO_MOVE_POINT = 10;

    CarRacingGame(String carNamesString, int tryCount) {
        this.tryCount = tryCount;
        String[] carNames = carNamesString.split(",");
        for (String carName : carNames) {
            this.carEntryList.add(new Car(carName));
        }
    }

    public List<Car> getCarEntryList() {
        return carEntryList;
    }

    // 게임 시작
    public void doGame() {
        System.out.println("\n실행 결과");
        for (int index = 0; index < this.tryCount; index++) {
            doRacing();
            // 게임 현황 출력
            ResultView.displayRacingState(this.carEntryList);
        }
    }

    private void doRacing() {
        this.carEntryList
                .forEach(vo -> vo.run(RandomUtil.generateRandomNumber(RANGE_TO_MOVE_POINT)));
    }

    private int getMaxCarPosition(){
        return this.carEntryList
                .stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(x -> x))
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Car> getWinnerList(){
        int maxPosition = getMaxCarPosition();
        return this.carEntryList
                .stream()
                .filter(vo->vo.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}

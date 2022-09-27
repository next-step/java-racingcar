package carRacing;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private final Integer tryCount;
    private final List<Car> carEntryList = new ArrayList<>();

    private final static int RANGE_TO_MOVE_POINT = 10;

    CarRacingGame(int numberOfCar, int tryCount) {
        this.tryCount = tryCount;
        for (int index = 0; index < numberOfCar; index++) {
            this.carEntryList.add(new Car());
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

}

package carRacing.domain;

import carRacing.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRacingGame {
    private final Integer tryCount;
    private final List<Car> carEntryList = new ArrayList<>();

    private final static int RANGE_TO_MOVE_POINT = 10;

    public CarRacingGame(String carNamesString, int tryCount) {
        this.tryCount = tryCount;
        String[] carNames = carNamesString.split(",");
        for (String carName : carNames) {
            this.carEntryList.add(new Car(carName));
        }
    }

    public List<Car> getCarEntryList() {
        return Collections.unmodifiableList(carEntryList);
    }

    // 게임 시작
    public RacingHistory doGame() {
        RacingHistory racingHistory = new RacingHistory();
        for (int round = 1; round <= this.tryCount; round++) {
            doRacing();
            racingHistory.doRecord(round, this.carEntryList);
        }
        return racingHistory;
    }

    private void doRacing() {
        this.carEntryList
                .forEach(vo -> vo.run(RandomUtil.generateRandomNumber(RANGE_TO_MOVE_POINT)));
    }


}

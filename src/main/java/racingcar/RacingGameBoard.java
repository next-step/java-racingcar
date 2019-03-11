package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class RacingGameBoard {

    private List<RacingCar> racingCars;
    private final int numberOfCars;
    private final int numberOfTimes;

    RacingGameBoard(final int numberOfCars, final int numberOfTimes) {
        this.numberOfCars = numberOfCars;
        this.numberOfTimes = numberOfTimes;

        this.initCars();
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfTimes() {
        return numberOfTimes;
    }

    private void initCars() {

        racingCars = new ArrayList<>(numberOfCars);

        for (int iCar = 0; iCar < numberOfCars; iCar++) {
            racingCars.add(new RacingCar());
        }
    }

    /**
     * 총 시도 회수만큼, 각 자동차들이 랜덤하게 움직이도록 처리한다.
     */
    public void play() {
        // 자동차들이 각 회수별로이동할 수 있는지 여부를 결정하는 랜덤 수 발생
        for (int iTime = 0; iTime < numberOfTimes; iTime++) {
            racingCars.forEach(RacingCar::makeRandomMove);
        }

        // 자동차들의 모든 회수의 랜덤 수 발생이후, 각 회수별 랜덤 수를 이동해야 할 위치로 변환
        racingCars.forEach(RacingCar::translateMovesToPositions);
    }

    /**
     * 각 회수별로 자동차의 위치를 출력한다.
     */
    public void show() {
        for (int iTime = 0; iTime < numberOfTimes; iTime++) {
            for (RacingCar racingCar : racingCars) {
                System.out.println(StringUtils.repeat("-", racingCar.getPositions().get(iTime + 1)));
            }

            System.out.println();
        }
    }
}

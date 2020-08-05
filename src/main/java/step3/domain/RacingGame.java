package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 자동차를 가지고 경기(게임)를 하는 클래스
 */
public class RacingGame {

    /**
     * 경기에 사용되는 자동차 목록
     */
    private List<Car> listOfCarsUsed;

    /**
     * 경기 시도 횟수
     */
    private int numberOfAttempts;

    /**
     * 현재 진행되고 있는 경기 Round
     */
    private int round;

    /**
     * 자동차의 갯수를 반환한다.
     *
     * @return
     */
    public int getNumberOfCars() {
        return this.listOfCarsUsed.size();
    }

    /**
     * 시도 횟수를 반환한다.
     *
     * @return
     */
    public int getNumberOfAttempts() {
        return this.numberOfAttempts;
    }

    /**
     * 현재 진행된 라운드를 반환한다.
     *
     * @return
     */
    public int getRound() {
        return this.round;
    }

    /**
     * 현재 게임에 이용되는 자동차 목록을 반환한다.
     *
     * @return
     */
    public List<Car> getListOfCarsUsed() {
        return this.listOfCarsUsed;
    }


    /**
     * 생성자를 설정해 초기화를 한다.
     *
     * @param namesOfCarsText
     * @param numberOfAttempts
     */
    public RacingGame(String namesOfCarsText, int numberOfAttempts) {
        this.listOfCarsUsed = this.createListOfCarsInUse(namesOfCarsText.split(","));
        this.numberOfAttempts = numberOfAttempts;

        this.round = 0;
    }

    /**
     * 자동차 게임에 진행시 사용되는 자동차 목록을 만들어 반환한다.
     *
     * @param namesOfCars
     * @return
     */
    private List<Car> createListOfCarsInUse(String[] namesOfCars) {
        return IntStream.range(0, namesOfCars.length)
                .mapToObj(index -> new Car(namesOfCars[index].trim()))
                .collect(Collectors.toList());
    }

    /**
     * 다음 경기 유무를 판별한다.
     *
     * @return
     */
    public boolean hasNextRace() {
        return this.round < this.numberOfAttempts;
    }

    /**
     * 자동차 경기를 진행한다.
     * 정해진 시도 횟수보다 많은 경기가 진행되지 않는다.
     */
    public void racing() {
        // 다음 경기의 유무를 확인해 진행 될 경기가 없는 경우에는 진행하지 않는다.
        if (!this.hasNextRace())
            return;

        for (Car car : this.listOfCarsUsed) car.go();

        this.round++;
    }
}

package racingcar.car.domain;

import racingcar.car.domain.winnerstrategy.WinnerStrategy;
import racingcar.car.ui.CarFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.random.RandomGenerator;

/**
 * Car 컬렉션을 관리하는 일급 컬렉션
 */
public class Cars {

    private List<Car> list;

    /**
     * 사용자로부터 입력받은 자동차 이름으로부터 Car 컬렉션을 생성한다.
     *
     * @param names 사용자가 입력한 자동차 이름으로, 쉼표로 구분한다. (ex. pobi,crong)
     */
    public Cars(String names) {
        list = Arrays.stream(split(names))
            .map(Car::new)
            .collect(Collectors.toList());
    }

    /**
     * 자동차 이름을 쉼표로 구분자로 구분한다.
     *
     * @param names 사용자로부터 입력받은 자동차 이름
     * @return 쉼표를 구분자로 구분된 자동차 이름 리스트
     */
    private String[] split(String names) {
        return names.split(",");
    }


    /**
     * 0 이상 10 미만의 랜덤값을 생성하여, 값에 따라 자동차를 이동시킨다.
     */
    public void move() {
        for (Car car : list) {
            car.move(RandomGenerator.extractRandomSingleDigit());
        }
    }

    /**
     * Car 컬렉션의 각 엘리먼트들을 출력한다.
     *
     * @param formatter Car 를 문자열로 포맷팅 할 포맷터
     */
    public void print(CarFormatter formatter) {
        list.forEach(car -> System.out.println(formatter.format(car)));
        System.out.println();
    }

    /**
     * 우승자 선출 전략에 따라 경주 우승자를 선출한다.
     *
     * @param winnerStrategy 우승자 선출 전략
     * @return 우승한 Car 리스트
     */
    public List<Car> getWinners(WinnerStrategy winnerStrategy) {
        return winnerStrategy.getWinners(list);
    }
}

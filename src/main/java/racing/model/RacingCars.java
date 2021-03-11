package racing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class RacingCars {

    private final List<RacingCar> carList;

    public RacingCars(String[] racingCarNames) {
        this.carList = createRacingCar(racingCarNames);
    }

    /**
     * 자동차이름을 이용해 생성해주는 메서드
     */
    public List<RacingCar> createRacingCar(String[] racingCarNames) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String racingCarName : racingCarNames) {
            racingCarList.add(new RacingCar(racingCarName));
        }
        return racingCarList;
    }

    /**
     * 자동차갯수를 반환하는 메서드
     */
    public int carCount() {
        return carList.size();
    }

    /**
     * 자동차를 이동하는 메서드
     */
    public RacingCars move(Iterator<Integer> randomValue) {
        for (RacingCar racingCar : carList) {
            racingCar.move(randomValue.next());
        }
        return this;
    }

    /**
     * 우승자를 설정하는 메서드
     */
    public List<String> findWinners() {
        RacingCar MaxPositionCar = new RacingCar("Max", 0);
        for (RacingCar racingCar : carList) {
            MaxPositionCar = getWinnerCar(racingCar, MaxPositionCar);
        }
        Position winnerPosition = MaxPositionCar.getPosition();

        return carList.stream()
                .filter(car -> car.isSame(winnerPosition))
                .map(RacingCar::getRacingCarName)
                .collect(toList());
    }

    public RacingCar getWinnerCar(RacingCar racingCar, RacingCar MaxRacingCar) {
        if (racingCar.isGreaterThan(MaxRacingCar)) {
            return racingCar;
        }
        return MaxRacingCar;
    }

    /**
     * 데이터 전송 객체 리스트를 만드는 메서드
     */
    public RacingCarsDto createDtoList() {
        List<RacingCarDto> carDtoList = carList.stream()
                .map(car -> new RacingCarDto(car.getRacingCarName(), car.getPosition()))
                .collect(toList());
        return new RacingCarsDto(carDtoList);
    }
}

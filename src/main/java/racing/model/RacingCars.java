package racing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class RacingCars {

    private final List<RacingCar> carList;

    public RacingCars(String[] racingCarNames) {
        boolean duplicated = Arrays.stream(racingCarNames)
                .distinct()
                .count() == racingCarNames.length;
        if (!duplicated) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
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
    public RacingCars move(List<Integer> randomValue) {
        int index = 0;
        for (RacingCar racingCar : carList) {
            carList.get(index).move(randomValue.get(index));
            index++;
        }
        return this;
    }

    /**
     * 우승자를 설정하는 메서드
     */
    public List<String> findWinners() {
        int winnerPosition = carList.stream()
                .max(comparing(RacingCar::getPosition))
                .orElseThrow(() -> new IllegalArgumentException("자동차가 없습니다."))
                .getPosition();

        return carList.stream()
                .filter(car -> car.isSame(winnerPosition))
                .map(RacingCar::getRacingCarName)
                .collect(toList());
    }

    /**
     * 데이터 전송 객체 리스트를 만드는 메서드
     */
    public List<RacingCarDto> createDtoList() {
        return carList.stream()
                .map((car) -> new RacingCarDto(car.getRacingCarName(), car.getPosition()))
                .collect(toList());
    }
}

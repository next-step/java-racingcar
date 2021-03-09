package racing.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingCars {

    private final List<RacingCar> carList;

    public RacingCars(String[] racingCarNames) {
        this.carList = createRacingCar(racingCarNames);
    }

    public List<RacingCar> getCarList() {
        return carList;
    }

    /**
     * 자동차이름을 이용해 생성해주는 메서드
     */
    public List<RacingCar> createRacingCar(String[] racingCarNames) {
        List<RacingCar> racingCarList = new ArrayList<>();
        long carId = 1L;
        for (String racingCarName : racingCarNames) {
            racingCarList.add(new RacingCar(racingCarName, 0));
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
    public void move(List<Integer> randomValue) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(randomValue.get(i));
        }
    }

    /**
     * 우승자를 설정하는 메서드
     */
    public List<String> findWinners() {
        int winnerPosition = carList.stream()
                .max(Comparator.comparing(RacingCar::getPosition))
                .orElseThrow(() -> new IllegalArgumentException("포지션의 값이 숫자가 아니거나 값이 없습니다."))
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

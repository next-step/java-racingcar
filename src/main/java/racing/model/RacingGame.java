package racing.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private final List<RacingCar> carList;

    public RacingGame(String[] racingCarNames) {
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
     * 자동차가 이동할 랜덤값 생성 메서드
     */
    public List<Integer> createRandomValue() {
        return new Random()
                .ints(0, 10)
                .limit(carList.size())
                .boxed()
                .collect(toList());
    }

    /**
     * 조건에 따라 자동차를 이동시켜주는 메서드
     */
    public List<RacingCar> moveAndStop(List<Integer> randomValue) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(randomValue.get(i));
        }
        return carList;
    }

    /**
     * 우승자를 설정하는 메서드
     */
    public List<String> setWinner() {
        int winnerPosition = carList.stream()
                .max(Comparator.comparing(RacingCar::getPosition))
                .orElseThrow(() -> new IllegalArgumentException("포지션의 값이 숫자가 아니거나 값이 없습니다."))
                .getPosition();

        return carList.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(RacingCar::getRacingCarName)
                .collect(toList());
    }


}

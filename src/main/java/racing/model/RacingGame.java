package racing.model;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private List<RacingCar> carList;

    private final Random random = new Random();

    public RacingGame(String participationList) {
        carList = new ArrayList<>();
        carList = createRacingCar(carNameParsor(participationList));
    }

    public List<RacingCar> getCarList() {
        return carList;
    }

    /**
     * 자동차이름을 이용해 생성해주는 메서드
     */
    public List<RacingCar> createRacingCar(String[] racingCarNames) {
        long carId = 1L;
        for (String racingCarName : racingCarNames) {
            carList.add(new RacingCar(carId++, racingCarName, 0));
        }
        return carList;
    }

    /**
     * 자동차가 이동할 랜덤값 생성 메서드
     */
    public List<Integer> createRandomValue() {
        List<Integer> randomValue = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            randomValue.add(random.nextInt(10));
        }
        return randomValue;
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
    public List<RacingCar> setWinner() {
        int winnerPosition = carList.stream()
                .max(Comparator.comparing(RacingCar::getPosition))
                .get()
                .getPosition();

        return carList.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(toList());
    }

    /**
     * 자동차 이름을 분할하는 메서드
     */
    public String[] carNameParsor(String participationList) {
        return participationList.split(",");
    }
}

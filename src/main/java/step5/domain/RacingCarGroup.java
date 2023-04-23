package step5.domain;

import step5.strategy.move.MoveStrategy;

import java.util.*;

import static java.util.stream.Collectors.toUnmodifiableList;

public class RacingCarGroup {
    private final static int THRESHOLD = 5;
    private List<RacingCar> racingCarList = new ArrayList<>();

    private RacingCarGroup(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public static RacingCarGroup from(String inputCarName) {
        List<RacingCar> racingCarList = makeRacingCarList(inputCarName);
        return new RacingCarGroup(racingCarList);
    }

    private static List<RacingCar> makeRacingCarList(String inputCarName) {
        validateEmpty(inputCarName);
        List<String> carNameList = getCarNameList(inputCarName);
        validateDuplicate(carNameList);
        validateHasLength(carNameList);

        return carNameList.stream()
                .map(carName -> {
                    validateEmpty(carName);
                    validateLessThen5Name(carName);
                    return RacingCar.from(carName);
                })
                .collect(toUnmodifiableList());
    }

    private static void validateLessThen5Name(String name) {
        if (name.length() > THRESHOLD) {
            throw new IllegalArgumentException("5자를 초과할수 없습니다");

        }
    }


    private static List<String> getCarNameList(String inputCarName) {
        return Arrays.asList(inputCarName.split(Separator.SPLIT_CAR_NAME_SEPARATOR.getSeparator()));
    }

    private static void validateEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
    }

    private static void validateDuplicate(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);

        if (carNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException("같은 이름이 있습니다");
        }
    }

    private static void validateHasLength(List<String> carNameList) {
        if (carNameList.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
    }

    public void move(MoveStrategy moveStrategy) {
        racingCarList.forEach(racingCar -> racingCar.move(moveStrategy));
    }

    public List<RacingCar> getWinner() {
        int winnerLocation = getWinnerLocation();

        return racingCarList.stream()
                .filter(racingCar -> racingCar.isWinner(winnerLocation))
                .collect(toUnmodifiableList());

    }

    public List<String> getWinnerName() {
        List<RacingCar> winner = getWinner();

        return winner.stream()
                .map(RacingCar::getName)
                .collect(toUnmodifiableList());
    }

    public int getWinnerLocation() {

        RacingCar sortedRacingCar = racingCarList.stream()
                .max(Comparator.comparingInt(RacingCar::getCurrentLocation))
                .orElseThrow(NoSuchElementException::new);

        return sortedRacingCar.getCurrentLocation();
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }
}

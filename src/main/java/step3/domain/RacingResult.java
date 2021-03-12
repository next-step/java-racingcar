package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * 컬렉션 정보를 관리하는 레이싱 결과를 담는 클래스
 */
public class RacingResult {

    private final List<RacingRound> racingRounds;

    public RacingResult() {
        this.racingRounds = new ArrayList<>();
    }

    public void addRacingRound(final RacingRound racingRound) {
        this.racingRounds.add(racingRound);
    }

    // 레이싱 결과를 담는 클래스에 우승자를 배열 타입으로 반환
    public String[] findWinners() {
        List<Car> cars = getLastRound();
        Position maxPosition = getMaxPosition(cars);

        List<Name> names = findWinnerNames(cars, maxPosition);
        return names.stream()
                .map(Name::getName)
                .toArray(String[]::new);
    }

    // 메서드 내에 기능을 분리 -> cars 리스트에서 maxPosition 에 해당하는 Name 리스트를 반환
    protected List<Name> findWinnerNames(List<Car> cars, Position maxPosition) {
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(Car::getName)
                .collect(toList());
    }

    // TODO 마지막 라운드를 가져오는 좋은 방법 찾기
    private List<Car> getLastRound() {
        return getRacingRounds()
                .get(racingRounds.size() - 1)
                .getCars();
    }

    // 자동차 리스트 -> Position 리스트 -> 가장 큰 값으로 반환
    protected Position getMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .reduce(Position::greaterThan)
                .orElseGet(Position::new);
    }

    public List<RacingRound> getRacingRounds() {
        return Collections.unmodifiableList(racingRounds);
    }
}

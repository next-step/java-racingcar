package racinggame.model.car;

import static racinggame.RandomNumberBox.getRandomNumber;
import static racinggame.ui.MC.printGameStates;

import java.util.ArrayList;
import java.util.List;
import racinggame.model.position.Position;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createByNames(List<String> carNames) {
        List<Car> carList = new ArrayList<>(carNames.size());

        for (String carName : carNames) {
            carList.add(
                    new Car(carName)
            );
        }

        return new Cars(carList);
    }

    public int size() {
        return this.cars.size();
    }

    // TODO : 일급컬랙인 Cars가 한 라운드 진행이라는 개념의 행동을 수행해도 적절할까요? 작성하고 다시 생각보니 이상적인 방향은 아닌것 같다는 생각이 듭니다
    public void playPerRound() {
        for (Car car : cars) {
            car.move(
                    getRandomNumber()
            );
            printGameStates(car);
        }
    }

    public Position findMaxPositions() {
        Position max = new Position();
        for (Car car : cars) {
            max = car.compareAndChangeIfMax(max);
        }

        return max;
    }

    public List<String> findWinners(Position maxPositions) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            judgeCarHasMax(maxPositions, car, winners);
            // if (car.isSamePosition(maxPositions)) {
            //     winners.add(car.getName());
            // }
        }

        return winners;
    }

    // TODO : 이렇게 외부 파라미터를 메서드 안에서 직접 수정/변경 하는 케이스는 어떻게 생각하시나요?
    //  다른 방법은 크게 생각나는 부분이 없어서 아래 방식 vs findWinners() 주석처리한 부분 이 두가지 방식중 선택했습니다
    private void judgeCarHasMax(
            final Position maxPositions,
            final Car car,
            final List<String> winners
    ) {
        String carNameIfMaxPosition = car.getCarNameIfMaxPosition(maxPositions);
        if (!carNameIfMaxPosition.isBlank()) {
            winners.add(carNameIfMaxPosition);
        }
    }
}

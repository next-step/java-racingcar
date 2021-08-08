package step4.model;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String nameList) {
        cars = new ArrayList<>();
//        nameList.forEach(name -> cars.add(new Car(name.trim())));
    }

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    /**
     * 자동차 인스턴스 반환
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * 자동차 움직임 기준에 따라 조정한다.
     * @param movingStrategy
     * @return
     */
    public List<String> moveAll(MovingStrategy movingStrategy){
        List<String> result = new ArrayList<>();

        cars.forEach(car -> {
            canMoveCar(movingStrategy, result, car);
        });

        return result;
    }

    /**
     * 랜덤 숫자가 4 이상이 나오면 전진한다.
     * @param movingStrategy
     * @param result
     * @param car
     */
    private void canMoveCar(MovingStrategy movingStrategy, List<String> result, Car car) {
        if (movingStrategy.canMove()) {
            car.go();
        }

        result.add(car.getName() + "/" + car.getPosition());
    }

    /**
     * 자동차들의 거리를 비교해 우승자를 뽑는다.
     * @return
     */
    public List<String> getTopMoveCar() {
        //모든 자동차의 거리를 담는다.
        List<Position> allCarsMove = cars.stream()
                                        .map(Car::getPosition)
                                        .collect(Collectors.toList());
        //정렬해서 가장 큰값을 가져온다.
        Collections.sort(allCarsMove, Collections.reverseOrder());
        Position max = allCarsMove.get(0);

        //자동차 이름을 따로 저장
        List<Name> winners = new ArrayList<>();
        getWinners(max, winners);
        List<String> names = getWinnersName(winners);

        return names;
    }

    private List<String> getWinnersName(List<Name> winners) {
        List<String> names = winners.stream()
                                    .map(Name::getName)
                                    .collect(Collectors.toList());

        return names;
    }

    /**
     * 최대 움직임과 같은 차들의 이름을 리스트에 담아 반환한다.
     * @param max
     * @param winners
     */
    public void getWinners(Position max, List<Name> winners) {
        for (Car car : cars) {
            isWinners(max, winners, car);
        }
    }

    private void isWinners(Position max, List<Name> winners, Car car) {
        if (max.equals(car.getPosition())) {
            winners.add(car.getName());
        }
    }
}

package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarGame {

    private final List<Car> cars;
    private final int rounds;

    public CarGame(int carCount, int rounds) {
        this.cars = new ArrayList<>(); // 생성자에서 선언하는게 좋음
        createCar(carCount);
        this.rounds = rounds;
    }

    // 1. 차량숫자 만큼 자동차를 만든다. ok
    // 2. 전진 할 로직 구현 // 랜덤넘버를 생성한다 ok
    // 3. 전진 하면 위치 기억 //램덤값이 4이상이면 앞으로 전진한다.
    // 4.게임 횟수만큼 2->3->4 로직을 반복 수행한다.
    // 5.화면에 출력한다.
    // car 입력받은 갯수만큼 만들어 리스트로 가져야지 객체이름은 단수여야지
    private List<Car> createCar(int carCount) {
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
        return cars;
    }

    public GameBoard start(int rounds) {

        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) { // 모든차를 다 같이 움직여야하자나
                car.forward();
            }
            // 끝? 근데 forward에 랜덤 넘버 까지 판단해
        }

        return null;
    }
}

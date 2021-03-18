package step4;


import step4.dto.InputDto;
import step4.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {

    private final List<Car> carList;
    private final InputDto inputDto;

    public RacingCar(InputDto inputDto) {
        this.carList = createCar(inputDto.getCarNameList());
        this.inputDto = inputDto;
    }

    public void start() {
        int tryCount = inputDto.getTryCount();

        for (int i = 0; i < tryCount; ++i) {
            move();
        }

        // 이런식으로 Main 클래스에서 start 메소드 부르고 start 에서 findWinner() 를 부르는 식으로 호출 깊이가 깊어질 수록 좋지 않겠죠 .. ?? ㅠ
        findWinner();
    }

    private void move() {
        for (int i = 0; i < carList.size(); ++i) {
            Car car = carList.get(i);
            car.carCanGoJudge(RandomNumber.randomNumberGenerator());

            // ResultView.print(car);  => 이렇게 바로 호출하는거랑 아래처럼 메소드를 통해서 호출하는거랑 차이가 있을까요??
            // 큰 차이가 없는 기분이네요 ㅠ ㅠ (메소드 끼리 괜한 의존관계를 만드는 것이 아닐지 의문입니다..)
            print(car);
        }

        System.out.println();
    }

    private void print(Car car) {
        ResultView.print(car);
    }

    private List<Car> createCar(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carNameList.size(); ++i) {
            cars.add(new Car(carNameList.get(i)));
        }

        return cars;
    }

    private void findWinner() {
        int maxDistance = maxDistance();

        // lambda stream 이 아직 어색한데 이렇게 하니 확실히 엄청 편한 거 같습니다 !!
        String winnerList = carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));

        // 이렇게 메소드 호출 -> 그 메소드에서 또 다른 메소드 호출 => 이러면 메소드 깊이가 깊어질 거 같은 느낌입니다.. (이래도 괜찮은걸까요?)
        ResultView.printWinner(winnerList);
    }

    // 제일 많이 간 거리를 구하는 메소드
    private int maxDistance() {
        carList.sort((o1, o2) -> o2.getDistance() - o1.getDistance());
        return carList.get(0).getDistance();
    }

    public List<Car> getCarList() {
        return carList;
    }
}

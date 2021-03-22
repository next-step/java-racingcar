package step5.domain;

import step5.dto.InputDto;
import step5.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private InputDto inputDto;

    // InputDto 랑 RacingGame 이 의존관계를 맺고 있어서 좋지 않은 거 같기도 한 느낌 입니다 ㅠ (이거 떄매 테스트 하기가 힘든 거 같습니담..)
    // InputDto 를 없애고 Refactor 할 수 있을 거 같은데 당장은 떠오르지 않아서 일단.. 리뷰 받고 고쳐보겠씁니다 ㅠ
    public RacingGame(InputDto inputDto) {
        this.cars = create(inputDto.getCarNameList());
        this.inputDto = inputDto;
    }

    // 테스트 코드를 위한 생성자
    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    // 외부에서 tryCount를 매개변수로 받아야 더 나을지.. 지금 처럼 필드로 InputDto 받아서 사용하는 것이 나을지 모르겠습니다 흑흑
    public void start() {
        for (int i = 0; i < inputDto.getTryCount(); ++i) {
            move(cars);
        }
    }

    private void move(List<Car> cars) {
        for (int i = 0; i < cars.size(); ++i) {
            Car car = cars.get(i);
            car.move(new RandomMovingStrategy());
            ResultView.print(car);
        }
        System.out.println();
    }

    // 테스트 코드를 작성하기 위해서 public 으로 만들어둔.. 메소드 인데 괜찮을 지 모르겠습니다 ㅠ(기존 메소드를 그냥 public 하는게 나을까요..)
    public List<Car> createTest(List<String> carNameList) {
        return create(carNameList);
    }

    private List<Car> create(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carNameList.size(); ++i) {
            carList.add(new Car(carNameList.get(i)));
        }

        return carList;
    }

    public String findWinner() {
        int maxDistance = maxDistance();

        return cars.stream()
                .filter(car -> car.getPosition().equals(new Position(maxDistance)))
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

    private int maxDistance() {
        // getter 너무 많이 쓰는데 줄이는 방법 생각 ! !  (너무 난잡) => Refactor 필요 (하.. 떠오르는 생각은 getter 뿐.. 부족합니다..)
        cars.sort((o1, o2) -> o2.getPosition().getPosition() - o1.getPosition().getPosition());
        return cars.get(0).getPosition().getPosition();
    }
}

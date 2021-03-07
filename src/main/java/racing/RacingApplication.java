package racing;

import racing.car.Car;
import racing.car.RandomMovement;
import racing.view.InteractiveInputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingApplication {

    public static void main(String[] args) {
        List<String> carNameList =
            InteractiveInputView.getListOfString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", ",");
        int moves = InteractiveInputView.getInt("시도할 회수는 몇 회 인가요?");

        List<Car> carList = carNameList.stream()
                                       .map(name -> new Car(new RandomMovement(), name))
                                       .collect(Collectors.toList());

        Racing racing = new Racing(carList, moves);
        racing.run();
    }

}

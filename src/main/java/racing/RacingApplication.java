package racing;

import racing.car.Car;
import racing.car.Movement;
import racing.car.RandomMovement;
import racing.view.InteractiveInputView;

import java.util.ArrayList;
import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {
        int carSize = InteractiveInputView.getInt("자동차 대수는 몇 대 인가요?");
        int moves = InteractiveInputView.getInt("시도할 회수는 몇 회 인가요?");

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carSize; i++) {
            Movement movement = new RandomMovement();
            carList.add(new Car(movement));
        }

        Racing racing = new Racing(carList, moves);
        racing.run();
    }

}

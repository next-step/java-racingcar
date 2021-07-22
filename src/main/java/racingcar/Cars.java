package racingcar;

import racingcar.ui.ResultView;
import racingcar.utils.CreateRandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public Cars(int carCount) {
        //아래 반복문을 메소드로 빼는게 좋을까요? 아니면 이대로 생성자 안에 둬도 괜찮은가요??
        for(int i=0; i<carCount; i++){
            cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(CreateRandomNumber.getRandomNumber());
        }
    }
}

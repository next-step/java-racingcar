package step3;

import java.util.ArrayList;
import java.util.List;

// 이렇게 하면 안되는 걸 알지만,,, 더 좋은 방법이 생각나지 않습니다 ㅠ
public class Racing {
    public static void racingCar(InputDto inputDto) {
        int carCount = inputDto.getCarCount();
        int tryCount = inputDto.getTryCount();

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carCount; ++i) {
            carList.add(new Car());
        }

        for (int i = 0; i < tryCount; ++i) {
            for (int j = 0; j < carList.size(); ++j) {
                Car car = carList.get(j);
                car.carCanGoJudge();
                ResultView.result(car);
            }
            System.out.println();
        }
    }
}

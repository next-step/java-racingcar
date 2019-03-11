package racinggame.View;

import racinggame.Vo.Car;
import java.util.List;

public class PrintRacing {

    // 결과를 출력하는 메서드
    public void printRacing(List<Car> carList) {
        System.out.println("실행 결과");

        for(Car car : carList) {
            System.out.println(car.getCountMoving());
        }
    }
}

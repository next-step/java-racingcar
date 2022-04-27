package teacher.step4.domain;

import java.util.ArrayList;
import java.util.List;

// 리펙터링 포인트: 메서드 추출, getter 메서드 의심, 객체의 상태를 변경을 통해 추출
// setter getter 사용하는 것은 안좋다.
// lombok 을 사용할 때도 주의하자.
public class Winners {
    public static List<Car> findWinners(List<Car> cars) {
        return findWInners(cars, maxPosition(cars));
    }

    // 인덴트를 줄이기 위해 노력했지만 더 이상 줄어지지 않을 땐 Stream 을 사용하고 Stream 은 객체 지향에 익숙해질 때까진 지양
    private static List<Car> findWInners(List<Car> cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            // 객체의 상태를 가져오는 getter 말고 해당 객체를 가지고있냐? 이런 식으로 물어보는 코드로 작성하자.
            // getter 메서드를 사용하려고 할 때 메세지를 물어볼수 없을까 고민,
            // getter 메서드 최소화하도록 노력하고 해당 로직을 객체 쪽으로 응집도가 높아지게 만들 수 있다.
            // 장점. 테스트 하기 쉬워진다,
            if (car.isWinner(maxPosition)) { // if (car.getPosition() == maxPosition)
                winners.add(car);
            }
        }
        return winners;
    }

    private static int maxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.maxPosition(maxPosition);
//            if (maxPosition < car.getPosition()) {
//                maxPosition = car.getPosition();
//            }
        }
        return maxPosition;
    }
}

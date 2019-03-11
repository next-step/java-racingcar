package racinggame.Controller;

import racinggame.View.PrintRacing;
import racinggame.Vo.Car;
import racinggame.Vo.Racing;
import java.util.List;

import static utils.GenerateRandom.generatingRandomNumber;

public class RacingGame {
    // 전진을 하기위한 조건 값
    private final int FORWARD_NUMBER = 4;
    private final int RANGE_RANDOM = 10;

    // 자동차 게임을 실제로 시작하는 행동
    public void game(int countCar, int countGame) {

        //--------------테스트를 위해 파라미터로 받아 실행하는 경우 -----------
        Racing racing = new Racing(countCar, countGame);
        PrintRacing printRacing = new PrintRacing();

        // 전진시킨 값을 출력한다.
        List<Car> carList = racing.getCarList();

        for(int i = 0; i < racing.getCountGame(); i++) {
            // 임의의 값을 생성하여 각각의 차가 전진할 수 있는지 여부를 결정한다.
            carForwardStatus(carList);
            // 결정 여부에 따라 전진 결과를 출력한다.
            printRacing.printRacing(carList);
            System.out.println();
        }
    }

    // 난수를 생성하여 자동차가 움직일지의 전진 여부를 결정하여 추가하는 메서드
    public void carForwardStatus(List<Car> carList) {
        for(Car car : carList) {
            int random = generatingRandomNumber(RANGE_RANDOM);

            // 난수가 4이상인 경우 전진한다.
            if (random > FORWARD_NUMBER) {
                car.setCountMoving((car.getCountMoving().append("-")));
            }
        }
    }
}

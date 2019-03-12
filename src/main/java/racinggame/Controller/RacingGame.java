package racinggame.Controller;

import racinggame.domain.Car;
import racinggame.domain.Racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racinggame.View.PrintRacing.printRacing;
import static racinggame.View.PrintRacing.printWinner;
import static utils.GenerateRandom.generatingRandomNumber;
import static utils.ConstantCollection.*;

public class RacingGame {
    // 자동차 게임을 실제로 시작하는 행동
    public void game(String carsName, int countCar, int countGame) {

        //--------------테스트를 위해 파라미터로 받아 실행하는 경우 -----------
        Racing racing = new Racing(carsName, countCar, countGame);

        // 전진시킨 값을 출력한다.
        List<Car> cars = racing.getCarList();

        for(int i = 0; i < racing.getCountGame(); i++) {
            // 임의의 값을 생성하여 각각의 차가 전진할 수 있는지 여부를 결정한다.
            carForwardStatus(cars);
            // 결정 여부에 따라 전진 결과를 출력한다.

            // 우승자를 정한다.
            printRacing(cars);
            System.out.println();
        }

        printWinner(getWinner(cars));
    }

    public List<String> getWinner(List<Car> cars) {
        List<Integer> carsMovement = new ArrayList<>();
        List<String> winnerName = new ArrayList<>();

        for(Car car : cars) {
            carsMovement.add(car.getCountMoving());
        }

        int maxMovement = carsMovement.isEmpty() ? -1 : Collections.max(carsMovement);

        for(Car car : cars) {
            // 승자 이름을 리턴한다.
            getWinnerName(car, maxMovement, winnerName);
        }

        return winnerName;
    }

    // 승자의 이름들을 저장하는 메서드
    public void getWinnerName(Car car, int maxMovement, List<String> winnderName) {
        if(car.getCountMoving() == maxMovement) {
            winnderName.add(car.getName());
        }
    }


    // 난수를 생성하여 자동차가 움직일지의 전진 여부를 결정하여 추가하는 메서드
    public void carForwardStatus(List<Car> cars) {
        for(Car car : cars) {
            int random = generatingRandomNumber(RANGE_RANDOM);

            // 난수가 4이상인 경우 전진한다.
            if (random > FORWARD_NUMBER) {
                car.addCountMoving();
                car.setViewMoving((car.getViewMoving().append("-")));
            }
        }
    }
}

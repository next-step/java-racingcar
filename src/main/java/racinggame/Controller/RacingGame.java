package racinggame.Controller;

import racinggame.carVo.Car;
import racinggame.carVo.Racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    //자동차 대수와 횟수를 입력받는다.

    // 자동차는 0과 9 사이에서 임의의 값을 지정 받고 4이상일 떄 만 움직인다.
    // 자동차는 전진 또는 멈출 수 있다.

    // 자동차 게임을 실제로 시작하는 행동
    public void game(int countCar, int countGame) {

        //--------------사용자에게 입력 받아 실행하는 경우 ----------
        // 입력한 횟수만큼 Racing의 carList를 만든다.
        // 자동차 대수와 시도할 횟수를 입력받는다.
        // 입력받은 자동차 개수와 횟수를 저장한다.
//        List<Integer> input = inputData();
//        Racing racing = new Racing(input.get(0), input.get(1));

        //--------------테스트를 위해 파라미터로 받아 실행하는 경우 -----------
        Racing racing = new Racing(countCar, countGame);

        // 전진시킨 값을 출력한다.
        List<Car> carList = racing.getCarList();

        for(int i = 0; i < racing.getCountGame(); i++) {

            // 임의의 값을 생성하여 각각의 차가 전진할 수 있는지 여부를 결정한다.
            setMovingYn(carList);
            // 결정 여부에 따라 전진 결과를 출력한다.
            printRacing(carList);
            System.out.println();
        }
    }

    public List<Integer> inputData() {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputCount = new ArrayList<>();
        System.out.println("자동차 대수는 몇 대 인가요?");
        inputCount.add(scanner.nextInt());

        System.out.println("시도할 횟수는 몇 회 인가요?");
        inputCount.add(scanner.nextInt());

        if(inputCount.size()< 0) {
            throw new IllegalArgumentException();
        }

        return inputCount;
    }

    // 난수를 생성하여 자동차가 움직일지의 전진 여부를 결정하여 추가하는 메서드
    public void setMovingYn(List<Car> carList) {
        for(Car car : carList) {
            int random = (int) (Math.random() * 10);

            // 난수가 4이상인 경우 전진한다.
            if (random > 4) {
                car.setCountMoving((car.getCountMoving().append("-")));
            }
        }
    }

    // 결과를 출력하는 메서드
    public void printRacing(List<Car> carList) {
        System.out.println("실행 결과");

        // 임의의 값을 자동차 개수만큼 생성한다.
        // 생성한 값을 자동차의 이동한 거리에 추가적으로 더해준다.

        for(Car car : carList) {
            System.out.println(car.getCountMoving());
        }
    }
}

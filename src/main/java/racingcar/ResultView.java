package racingcar;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    public ResultView() {
    }

    public void printResult(int tryTimes, List<Car> carList) {
        System.out.println("실행 결과");
        cycleTryTimes(tryTimes, carList);
    }

    private static void cycleTryTimes(int tryTimes, List<Car> carList) {
        for (int i = 0; i < tryTimes; i++) {
            cycleCarMove(carList);
            System.out.println();
        }
    }

    private static void cycleCarMove(List<Car> carList) {

        RandomNum randomNum = new RandomNum();

        for (Car car : carList) {
            int randNum = randomNum.createRandNum();
            String positionView = car.moveCar(car.isMoveAble(randNum));
            System.out.println(positionView);
        }
    }

}

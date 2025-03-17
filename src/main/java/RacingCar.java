import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static void main(String[] args) {

        int carCount = InputView.getAnswerToInteger("자동차 대수는 몇 대 인가요?");

        List<Car> carList = generateCarList(carCount);

        int tryTimes = InputView.getAnswerToInteger("시도할 회수는 몇 회 인가요?");

        System.out.println("실행 결과");

        for (int j = 0; j < tryTimes; j++) {
            moveCars(carList);
            System.out.println();
        }
    }

    private static void moveCars(List<Car> carList) {
        for (Car car : carList) {
            car.move();
            ResultView.printResult(car.showDistance());
        }
    }

    private static List<Car> generateCarList(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }
}
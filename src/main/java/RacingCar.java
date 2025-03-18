import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static void main(String[] args) {

        int carCount = InputView.getAnswerToInteger("자동차 대수는 몇 대 인가요?");

        List<Car> cars = generateCars(carCount);

        int tryTimes = InputView.getAnswerToInteger("시도할 회수는 몇 회 인가요?");

        System.out.println("실행 결과");

        for (int j = 0; j < tryTimes; j++) {
            moveCars(cars);
            ResultView.println("");
        }
    }

    private static void moveCars(List<Car> carList) {
        for (Car car : carList) {
            car.move(RandomUtils.generateRandomNumber(10));
            ResultView.printResult(car);
        }
    }

    private static List<Car> generateCars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }
}
package car;

import java.util.List;

public class ResultWinnerCarView implements ResultView{
    @Override
    public void print(List<Car> cars, int tryNum) {
        System.out.println("실행 결과");

        for(int i = 0; i < tryNum; i++) {
            for (Car car : cars) {
                car.racing();
            }
        }
        printWinner(cars);
    }

    private void printWinner(List<Car> cars) {

    }
}

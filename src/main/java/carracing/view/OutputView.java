package carracing.view;

import carracing.domain.Car;

import java.util.List;

public class OutputView {

    public void getResultView(List<Car> cars) {
        cars.stream()
                .forEach(car -> showResultByCar(car));
        System.out.println("");
    }

    private void showResultByCar(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append("-");
        }
        System.out.println(car.getCarName() + " : " + stringBuilder);
    }

    public void viewWinner(String winnerName) {
        System.out.println(winnerName + "가 최종 우승했습니다.");
    }
}

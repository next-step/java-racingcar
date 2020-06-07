package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class ResultView {

    public ResultView(String message) {
        System.out.println(message);
    }

    public void print(List<Cars> allRoundCars) {
        for (Cars cars : allRoundCars) {
            printRoundPosition(cars.getCarList());

            System.out.println();
        }
    }

    public void printFinalWinner(List<Car> winners) {
        StringBuilder winnersName = new StringBuilder();
        for (Car winner : winners) {
            winnersName.append(winner.getName()).append(" ");
        }
        System.out.println(winnersName.toString().trim().replace(" ", ", ") + "가 최종 우승하였습니다.");
    }

    private void printRoundPosition(List<Car> carList) {
        for (Car car : carList) {
            drawCar(car);
        }
    }

    private void drawCar(Car car) {
        StringBuilder paper = new StringBuilder(car.getName());
        paper.append(" : ");
        int position = car.getPosition();

        for (int i = 0; i < position; i++) {
            paper.append("-");
        }

        System.out.println(paper.toString());
    }
}

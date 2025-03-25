package view.presenter;

import java.util.List;
import java.util.stream.Collectors;

import domain.Car;
import domain.Racing;

public class RacingConsoleUIPresenter implements RacingUIPresenter {

    private final CarUIPresenter carUIPresenter = new CarConsoleUIPresenter();

    @Override
    public void printCurrentStatus(Racing racing) {
        List<Car> carList = racing.getCarList();

        for (Car car : carList) {
            carUIPresenter.print(car);
        }

        System.out.print("\n");
    }

    @Override
    public void printWinner(Racing racing) {
        if (racing.isRemainTry()) {
            throw new RuntimeException("아직 시도할 횟수가 남아 있습니다.");
        }

        List<Car> winnerList = racing.getWinner();

        String result = winnerList.stream()
            .map(Car::getCarName)
            .collect(Collectors.joining(","));

        System.out.println(result + "가 최종 우승했습니다.");
    }
}

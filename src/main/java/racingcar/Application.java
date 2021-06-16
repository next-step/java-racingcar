package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Ready ready = new Ready();
        Input input = new Input();
        Award award = new Award();

        List<Car> cars = ready.createCars(input.carName());
        int gameCount = input.gameCount();

        Stadium stadium = new Stadium(cars, gameCount);
        stadium.playRace();

        List<Car> winner= award.findWinner(stadium.getCars());
        System.out.println("최종 우승자 : " + award.winnerIS(winner));
    }
}

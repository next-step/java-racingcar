package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Ready ready = new Ready();

        List<Car> cars = ready.createCars(input.carName());
        int gameCount = input.gameCount();

        Stadium stadium = new Stadium(cars, gameCount);
        stadium.playRace();

        List<Car> result = stadium.award();
        System.out.println("최종 우승자 : " + stadium.winnerIS(result));
    }
}

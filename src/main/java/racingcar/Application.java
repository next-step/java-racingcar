package racingCar2;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Ready ready = new Ready();
        Stadium stadium = new Stadium();

        // input
        String name = input.carName();
        int number = input.gameNumber();

        // ready
        String[] playerList = ready.createPlayerList(name);
        List<Car> cars = ready.createCars(playerList);

        // game
        System.out.println("실행 결과");
        for (int i = 0; i < number; i++) {
            for (Car car : cars) {
                int randomNumber = stadium.drawRandomNumber();
                stadium.run(car, randomNumber);
                System.out.println(car.getName() + ":" + stadium.process(car.getPosition()));
            }
        }

        // 가장 큰 position 구하기
        int maxScore = stadium.findMaxScore(cars);
        System.out.println(maxScore);

        // 우승자
        List<String> winners = stadium.winners(cars, maxScore);
        stadium.winnerIs(winners);
    }
}

package racingcar;

public class RacingGame {

    public RacingGame(Cars cars, int numberOfGames) {
        for (int i = 0; i < numberOfGames; i++) {
            cars.move();
        }
        cars.saveWinnerCar();
        System.out.println(cars.getWinner()+ " 가 우승하였습니다.");
    }
}


package racingcar.service;

import racingcar.repository.RacingRepository;

public class RacingService {
    private final RacingRepository repository = new RacingRepository();


    public void makeCars(int input) {
        repository.makeCars(carCount(input));
    }

    public int carCount(int input) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return input;
    }


    public int moveCount(int input) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return input;
    }

    public void moveCar() {
        repository.moveCar(repository);
    }


}

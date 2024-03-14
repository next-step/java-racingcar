package racingcar.service;

import racingcar.repository.RacingRepository;

public class RacingService {
    private final RacingRepository repository;

    public RacingService(RacingRepository repository) {
        this.repository = repository;
    }


    public void makeCars(int cnt) {
        repository.makeCars(cnt);
    }


    public void totalTry(int cnt) {
        repository.totalTry(cnt);
    }

    public void racing() {
        System.out.println("실행 결과");
        int Try = repository.getTotalTry();
        while (Try > 0) {
            repository.moveCar();
            repository.position();
            Try--;
            System.out.println();
        }

    }
}

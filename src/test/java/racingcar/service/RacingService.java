package racingcar.service;

import racingcar.repository.RacingRepository;

import java.util.Scanner;

public class RacingService {
    private final RacingRepository repository = new RacingRepository();


    public void makeCars() {
        repository.makeCars(carCount());
    }

    public int carCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");

        return count();
    }


    public int moveCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return count();
    }

    public void moveCar() {
        repository.moveCar(repository);
    }

    private int count() {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        if (cnt <= 0) throw new IllegalArgumentException("잘못된 입력값 입니다");
        return cnt;
    }
}

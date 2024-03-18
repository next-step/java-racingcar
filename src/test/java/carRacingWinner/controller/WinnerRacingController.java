package carRacingWinner.controller;

import carRacingWinner.entity.Name;
import carRacingWinner.repository.WinnerRepository;
import carRacingWinner.service.WinnerService;

import java.util.Scanner;

public class WinnerRacingController {

    private Name input;
    private WinnerRepository winnerRepository;

    public void racingStart() {
        carsNameInput();
        int cnt = tryCount();
        winnerRepository.makeCars(input.getName());
        System.out.println("실행 결과");
        winnerRepository.presentLocation();

        while (cnt > 0) {
            cnt--;
        }
    }

    public void carsNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        input = new Name(input());
    }

    private int tryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int cnt = Integer.parseInt(input());
        if (cnt < 0)
            throw new IllegalArgumentException("잘못된 시도 횟수 입니다");
        return cnt;
    }

    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}

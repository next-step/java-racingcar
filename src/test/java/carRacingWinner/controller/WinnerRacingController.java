package carRacingWinner.controller;

import carRacingWinner.entity.Car;
import carRacingWinner.entity.Name;
import carRacingWinner.entity.Winner;
import carRacingWinner.repository.WinnerRepository;


import java.util.List;
import java.util.Scanner;

public class WinnerRacingController {

    private Name input;
    private WinnerRepository winnerRepository;
    private Winner winner;

    public void racingStart() {
        carsNameInput();
        int cnt = tryCount();
        winnerRepository.makeCars(input.getName());
        System.out.println("실행 결과");
        winnerRepository.presentLocation();

        while (cnt > 0) {
            winnerRepository.moveCars();
            winnerRepository.presentLocation();
            cnt--;
        }
        winner.printWinner(winnerRepository.getCars());
        printFinalResult(winner.getWinner());
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

    private void printFinalResult(List<Car> winners) {
        for (int i = 0; i < winners.size() - 1; i++) {
            System.out.println(winners.get(i).getName() + ", ");
        }
        System.out.println(winners.get(winners.size() - 1).getName() + "가 최종 우승했습니다");
    }
}

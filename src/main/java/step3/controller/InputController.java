package step3.controller;

import java.util.Scanner;

public class InputController {
    public Input handleInput() {
        System.out.println("초간단 자동차 게임을 시작합니다!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대인가요?");
        int participantsNumber = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회인가요?");
        int roundNumbers = scanner.nextInt();

        return new Input(participantsNumber, roundNumbers);
    }
}


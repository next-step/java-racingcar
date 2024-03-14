package carRacingWinner.controller;

import java.util.Scanner;

public class WinnerRacingController {

    public void racingStart() {

    }

    public String[] carsNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = division(input());
        return names;
    }

    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public String[] division(String names) {
        String[] words = names.split(",");
        for (String word : words) {
            if (lengthCheck(word))
                throw new IllegalArgumentException("길이가 깁니다");
        }
        return words;
    }

    public boolean lengthCheck(String name) {
        return name.length() > 5;
    }
}

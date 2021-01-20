package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGameController {
    ArrayList<RacingCar> cars = new ArrayList<>();

    public void getCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] inputs = input.split(",");
        for (int i=0; i<inputs.length; i++){
            cars.add(new RacingCar(inputs[i]));
        }
    }

    public void getRound() {

    }

    public void findWinner() {

    }
}

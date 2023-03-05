package racingcar;

import java.util.Scanner;

public class racing_main {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String car_names = input.next();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int track = input.nextInt();

        racing_game game = new racing_game();
        String result = game.play(car_names,track);

        System.out.println("최종 우승자: "+result);
    }
}

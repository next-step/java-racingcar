package racing.racing;

import racing.racingrebuild.Car;
import racing.racingrebuild.NewRacing;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = null;
        int count = 0;
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        name = in.nextLine();
        System.out.println("===========================");
        System.out.println("시도할 횟수는 몇 회인가요?");
        count = Integer.valueOf(in.nextLine());

        NewRacing newRacing = new NewRacing();
        ArrayList<Car> car = newRacing.raceStart(name,count);
        newRacing.winner(car);
    }


}

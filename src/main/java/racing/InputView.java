package racing;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner carScanner = new Scanner(System.in);
        int numberOfCars = carScanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner playScanner = new Scanner(System.in);
        int numberOfPlays = playScanner.nextInt();

        Race race = new Race(numberOfCars, numberOfPlays);

        race.play();

        System.out.println("실행 결과");
        ArrayList<ArrayList<String>> result = race.result();
        for (ArrayList<String> strings : result) {
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println();
        }
    }
}

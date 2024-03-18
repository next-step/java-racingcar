package step3;

import step3.object.Car;
import step3.util.StringSplitter;

import java.util.List;
import java.util.Scanner;

public class RacingApplication {

    private static final StringSplitter stringSplitter = new StringSplitter();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //step 3
//        System.out.println("자동차 대수는 몇 대 인가요? ");
//        int racingCarCount = scan.nextInt();

        //step 4
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameListString = scan.nextLine();
        List<String> carNameList = stringSplitter.getNameList(nameListString);

        System.out.println("시도할 회수는 몇 회 인가요? ");
        int trials = scan.nextInt();
        step3.Race race = new step3.Race();
        List<Car> carList = race.generateCarList(carNameList);
        // 게임 진행
        for (int turn = 0; turn < trials; turn++) {
            race.startMoving(carList);
            step3.ViewPrinter viewPrinter = new step3.ViewPrinter(carList);
            viewPrinter.printCars();
        }
        List<Car> winnerList = race.findWinnerList(carList);
        step3.ViewPrinter viewWinnerPrinter = new step3.ViewPrinter(carList);
        viewWinnerPrinter.printWinners(winnerList);
    }
}

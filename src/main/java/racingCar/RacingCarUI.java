package racingCar;

import java.util.Scanner;

import static racingCar.RacingCar.selectWinner;
import static racingCar.RacingCar.showPosition;

public class RacingCarUI {

    static Scanner sc = new Scanner(System.in);
    //자동차 이름 입력
    public static String inCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();

    }
    //시도횟수 입력
    public static int inTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();

    }
    //실행결과 출력
    public static void outResult(CarVO[] cars){
        for(CarVO car : cars) {
            System.out.println(car.name + " : " + showPosition(car.position));
        }
        System.out.println();

    }
    //우승자 출력
    public static void outWinners(CarVO[] cars){
        String result = selectWinner(cars);
        System.out.println(result + " 가 최종 우승했습니다.");

    }
}

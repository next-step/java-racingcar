package racingCar;

import java.util.List;
import java.util.Scanner;

import static racingCar.Car.getResult;
import static racingCar.RacingCarWinner.*;


public class RacingCarUI {

    static Scanner sc = new Scanner(System.in);

    //자동차 이름 입력
    public static String inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();

    }
    //시도횟수 입력
    public static int inputTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();

    }
    //실행결과 출력
    public static void outputResult(Car[] cars){
        for(Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();

    }
    //우승자 출력
    public static void outputWinners(List<Car> list){
        String result = getResult(winnerList(sortingList(list)));
        System.out.println(result + " 가 최종 우승했습니다.");

    }

    //이동거리를 숫자 -> 문자로 변환시키기
    public static String showPosition(int distance) {
        String position = "";
        for (int i = 0; i < distance; i++) {
            position += '-';
        }
        return position;
    }

}

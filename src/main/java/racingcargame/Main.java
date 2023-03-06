package racingcargame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요? (10 이하 숫자만 입력)");
        int i = 0;
        int carCnt = sc.nextInt();
        String[] carName = new String[carCnt];
        List<Car> carList = new ArrayList<Car>();
        while (i < carCnt) {
            System.out.println(i + 1 + "번째 자동차 이름을 입력하세요. (5자 이하)");
            Car car = new Car(sc.next(), 0);
            carList.add(car);
            System.out.println("carList[" + i + "] : " + carList.get(i).getName());
            i++;
        }
        Racing racing = new Racing();
        racing.cars = carList;
        System.out.println("시도할 횟수는 몇회인가요?");
        racing.tryCnt = sc.nextInt();

        i = 0;
        System.out.println("실행결과");
        while (i < racing.tryCnt) {
            //레이스 수행
            racing.race(carList);
            //레이스 결과 출력
            racing.print(carList);
            i++;
        }
        String winner = "";

        System.out.println("최종 우승자: " + racing.getWinner(carList));
    }
}

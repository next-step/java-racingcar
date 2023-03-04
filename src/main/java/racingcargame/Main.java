package racingcargame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요? (10 이하 숫자만 입력)");
        int i=0;
        int carCnt = sc.nextInt();
        String [] carName = new String[carCnt];
        List<Car> carList = new ArrayList<Car>();
        while(i < carCnt){
            System.out.println(i+1 + "번째 자동차 이름을 입력하세요. (5자 이하)");
            Car car = new Car();
            car.name = sc.next();
            car.score = 0;  //초기스코어세팅
            carList.add(car);
            System.out.println("carList["+i+"] : " + carList.get(i).name);
            i++;
        }
        Racing race = new Racing();
        race.carList = carList;
        System.out.println("시도할 횟수는 몇회인가요?");
        race.tryCnt = sc.nextInt();

        //레이스 수행
        //race.run();

        //레이스 결과 출력

    }
}

package step3;

import java.util.ArrayList;
import java.util.List;

public class SimpleRacingCar {

    public static void main(String[] args) {

        //몇 대의 자동차로 몇 번의 이동을 할 것인지 사용자 입력받기
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCnt = InputView.inputInfo();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int repeatCnt = InputView.inputInfo();

        //입력받은 대수의 자동차 생성 및 각 자동차의 랜덤값 발생시키기
        List<Car> racingCarList = createCar(carCnt, repeatCnt);
    }

    public static List<Car> createCar(int carCnt, int repeatCnt) {
        List<Car> carList = new ArrayList<Car>();

        for(int num=0; num<carCnt; num++){
            carList.add(new Car(num,repeatCnt));
        }

        return carList;
    }
}

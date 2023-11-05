package racing;


import java.util.ArrayList;
import java.util.List;

public class GameMain {

    public static void main(String[] args) {

        //게임 데이터 입력
        GameData data = GameData.userInput();
        System.out.println("user input data = " + data.inputData());

        //자동차 생성
        generateCar(data.carData());

        //게임 진행 & 상태 출력
    }

    public static List<Car> generateCar(int number) {

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Car car = new Car(i);
            cars.add(car);
        }
        return cars;
    }
}

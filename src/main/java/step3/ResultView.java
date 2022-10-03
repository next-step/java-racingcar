package step3;
import java.util.ArrayList;

public class ResultView {
    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = InputView.input();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int raceCount = InputView.input();

        ArrayList<Car> cars = carMaker(carCount);

        System.out.println("\n실행 결과");
        Race.result(cars,raceCount);


        }

    public static ArrayList<Car> carMaker(int carCount) {
        ArrayList<Car> cars = new ArrayList<Car>();

        for(int count = 1; count <= carCount; count++){
            cars.add(new Car(1));
        }

        return cars;
    }

}

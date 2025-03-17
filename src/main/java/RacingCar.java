import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCar {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int carCount = getAnswerToInteger("자동차 대수는 몇 대 인가요?");
        int tryTimes = getAnswerToInteger("시도할 회수는 몇 회 인가요?");

        System.out.println("실행 결과");

        List<Car> carList = generateCarList(carCount);

        for(int j = 0; j < tryTimes; j++){
            moveCars(carList);
            System.out.println();
        }
    }

    private static void moveCars(List<Car> carList) {
        for(Car car : carList) {
            car.move();
            System.out.println(car.showDistance());
        }
    }

    private static List<Car> generateCarList(int carCount) {
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < carCount; i++){
            carList.add(new Car());
        }
        return carList;
    }

    public static int getAnswerToInteger(String question){
        int num = 0;
        while(true){
            try{
                System.out.println(question);
                num = scanner.nextInt();
                break;
            }catch(Exception e){
                System.out.println("유효하지 않은 타입입니다.");
            }
        }
        return num;
    }
}

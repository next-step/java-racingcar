package step4;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {

    private List<Car> carList = new ArrayList<Car>();

    private List<Car> init(String value) {
        String[] list = value.split(",");

        for(int i = 0 ; i < list.length ; i ++) {
            carList.add(new Car(list[i]));
        }

        return carList;
    }

    public void run(String value, int number) {
        List<Car> cars = init(value);

        for(int i = 0 ; i < number; i ++) {
            cars.stream()
                    .forEach(car -> {
                        car.run(getRandomNum());
                    });
            System.out.println();
        }

        System.out.println(getWinner(cars)+"가 최종 우승했습니다.");
    }

    public String getWinner(List<Car> cars) {
        StringBuilder str = new StringBuilder();

        cars.sort( (a, b) -> b.getCurrentStatus() - a.getCurrentStatus());

        str.append(cars.get(0).getOwner());
        int max = cars.get(0).getCurrentStatus();
        int size = cars.size();
        for(int i = 1 ; i < size; i ++) {

            Car currentCar = cars.get(i);
            if(max != currentCar.getCurrentStatus()) {
                break;
            }
            str.append(",").append(currentCar.getOwner());
        }

        return str.toString();
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public int getCarListSize(){
        return carList.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String value = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int number = scanner.nextInt();

        RacingCar racingCar = new RacingCar();

        racingCar.run(value, number);
    }
}

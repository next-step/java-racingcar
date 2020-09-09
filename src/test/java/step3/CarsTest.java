package step3;

import org.junit.jupiter.api.Test;
import step3.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarsTest {

    @Test
    void findWinner() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputNames = "min,finn,jake";
        System.out.println(inputNames);
        System.out.println("시도할 회수는 몇회인가요?");
        int count = 5;
        System.out.println(count);
        System.out.println();
        System.out.println("실행결과");

        String[] arr = inputNames.split(",");

        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            Car car = new Car();
            car.setName(arr[i]);
            car.setPosition(0);
            cars.add(car);
        }

        for(int i = 0; i < count; i++) {
            for(int j = 0; j < cars.size(); j++) {
                int position = cars.get(j).getPosition() + process();
                cars.get(j).setPosition(position);
                System.out.println(resultView(cars.get(j)));
            }
            System.out.println();
        }

        List<String> winners = new ArrayList<>();
        for(int i = 0; i < cars.size(); i++) {
            if(cars.get(i).getPosition() == count) {
                winners.add(cars.get(i).getName());
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i));
            if(i != winners.size() - 1) {
                sb.append(",");
            }
        }
        if(winners.size() > 0) {
            sb.append("가 최종 우승했습니다.");
            System.out.println(sb.toString());
        }
        if(winners.size() == 0) {
            System.out.println("우승자가 없습니다.");
        }
    }

    private String resultView(Car car) {
        String result = car.getName() + ":";
        for(int i = 0; i < car.getPosition(); i++) {
            result += '-';
        }
        return result;
    }

    private int process() {
        Random random = new Random();
        int randomNum = random.nextInt(10);

        if(randomNum >= 4) {
            return 1;
        }
        return 0;
    }
}

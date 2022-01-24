package racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CarGenerator {

    public List<Car> createCars(int moveThreshold) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        final String[] names = br.readLine().split(",");
        final List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name, moveThreshold));
        }

        return cars;
    }
}

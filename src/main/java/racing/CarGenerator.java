package racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CarGenerator {

    final int carNameLength;

    public CarGenerator(int carNameLength) {
        this.carNameLength = carNameLength;
    }

    public List<Car> generateCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            validateNameLength(names[i]);
            cars.add(new Car(names[i]));
        }
        return cars;
    }

    public String[] readCarName() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String[] names = br.readLine().split(",");
        return names;
    }

    private void validateNameLength(String name) {
        if (name.length() > this.carNameLength) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}

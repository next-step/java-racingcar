package racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final List<Car> cars;
    private final int roundNumber; //경주 횟수

    public Racing(List<Car> cars) throws IOException {
        this.cars = cars;

        //TODO: Step2에서 리팩토링
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("시도할 횟수는 몇회인가요?");
        this.roundNumber = Integer.parseInt(br.readLine());
    }

    public void race() {
        for (int i = 0; i < roundNumber; i++) {
            startRound();
            System.out.println();
        }
    }

    private void startRound() {
        for (Car car : cars) {
            car.move();
            car.printDistance(); //TODO: Step2에서 리팩토링
        }
    }
}

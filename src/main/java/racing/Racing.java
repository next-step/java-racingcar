package racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Racing {

    private final List<Car> cars;
    private int roundNumber;

    public Racing(List<Car> cars){
        this.cars = cars;
        initRoundNumber();
    }

    private void initRoundNumber() {
        try {
            //TODO: Step2에서 리팩토링
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("시도할 횟수는 몇회인가요?");
            this.roundNumber = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("[ERROR] 입출력 예외 발생");
        }
    }

    public List<Car> race() {
        for (int i = 0; i < roundNumber; i++) {
            startRound();
            System.out.println();
        }
        return cars;
    }

    private void startRound() {
        for (Car car : cars) {
            car.move(makeRandom());
            car.printDistance(); //TODO: Step2에서 입출력 분리 리팩토링 예정
        }
    }

    private int makeRandom() {
        return (int) (Math.random() * 10);
    }
}

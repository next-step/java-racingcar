package racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final List<Car> cars;
    private final List<RoundResult> results = new ArrayList<>();
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

    public void race() {
        while (roundNumber-- > 0) {
            results.add(Round.play(cars));
        }
        printResult();
    }

    private void printResult() {
        for(RoundResult result : results) {
            System.out.println(result.getStringResult());
        }
    }

    public List<Car> getLastResult() {
        final int LAST_INDEX = results.size() - 1;
        return results.get(LAST_INDEX).getCars();
    }
}

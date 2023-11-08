package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RacingInputView {

    private BufferedReader br;
    private CarRacing carRacing;
    private RacingResultView resultView;

    public RacingInputView() {
    }

    public RacingInputView(CarRacing carRacing) {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.carRacing = carRacing;
        this.resultView = new RacingResultView(carRacing);
    }

    public void inputNumOfCars() throws IOException {
        System.out.println("자동차 대수는 몇 대 인가요?");

        carRacing.createCarsOf(Integer.parseInt(br.readLine()));
    }

    public void inputNumOfTry() throws IOException {
        System.out.println("시도할 횟수는 몇 회 인가요?");

        resultView.printCarRacing(Integer.parseInt(br.readLine()));
    }
}

package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarRacing {

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    private List<Integer> movingDistances;

    public CarRacing() {
        displayInputView();
    }

    public void start() {
        int totalTurns = inputView.getInputData().getNumOfTry();
        readyToRace(inputView.getInputData().getNumOfCars());

        int currentTurn = 1;
        System.out.println("실행 결과");

        while (currentTurn <= totalTurns) {
            tryMovingAllCars();
            displayCurrentMovingDistances();
            currentTurn++;
        }
    }

    private void displayInputView() {
        inputView.draw();
    }

    private void displayCurrentMovingDistances() {
        resultView.draw(movingDistances);
    }

    /**
     * race 에 참여한 모든 car 들이 이동을 시도한다
     */
    private void tryMovingAllCars() {
        List<Integer> currentMovingDistance = Collections.unmodifiableList(movingDistances);
        this.movingDistances = currentMovingDistance
                .stream()
                .map(this::move)
                .collect(Collectors.toList());
    }

    /**
     * Random 값이 4이상 이동하고 그렇지 않으면 이동하지 않는다
     *
     * @param currentDistance
     * @return
     */
    private Integer move(Integer currentDistance) {
        if (new Random().nextInt(10) >= 4) return currentDistance + 1;

        return currentDistance;
    }

    private void readyToRace(int numOfCars) {
        movingDistances = new ArrayList<>(numOfCars);
        while (numOfCars-- > 0) {
            movingDistances.add(0);
        }
    }

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.start();
    }
}

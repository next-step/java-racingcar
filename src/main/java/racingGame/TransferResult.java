package racingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TransferResult {
    private List<String> result = new ArrayList<>();
    private List<Car> gameResult;

    public TransferResult(List<Car> gameResult) {
        this.gameResult = gameResult;
    }

    public void getRoundResult() {
        int tryIndex = 0;
        int carIndex = 0;
        replaceAllRound(tryIndex, carIndex);
    }

    private void replaceAllRound(int tryIndex, int carIndex) {
        while (tryIndex < gameResult.get(carIndex).size()) {
            replaceEachRound(tryIndex, carIndex);
            System.out.println();
            carIndex = 0;
            tryIndex++;
        }
    }

    private void replaceEachRound(int tryIndex, int carIndex) {
        while (carIndex < gameResult.size()) {
            addRoundResult(carIndex, tryIndex);
            System.out.println(getEachRoundResult(carIndex));
            carIndex++;
        }
    }

    private void addRoundResult(int carIndex, int tryIndex) {
        if (result.size() < gameResult.size()) {
            result.add(gameResult.get(carIndex).getCarTracesValue(tryIndex));
            return;
        }
        checkTrace(carIndex, gameResult.get(carIndex).getCarTracesValue(tryIndex));
    }

    private String getEachRoundResult(int index) {
        return result.get(index);
    }

    private void checkTrace(int index, String carTrace) {
        if (Objects.equals(carTrace, "-")) {
            addTrace(index, carTrace);
        }
    }

    private void addTrace(int index, String carTrace) {
        StringBuilder sb = new StringBuilder();
        sb.append(result.get(index));
        sb.append(carTrace);
        result.set(index, sb.toString());
    }
}

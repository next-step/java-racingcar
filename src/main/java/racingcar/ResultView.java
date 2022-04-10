package racingcar;

public class ResultView {

    // TODO 각 라운드별로 출력할 수 있게 변경 [2022.04.10 - hahoho87]
    public void printResult(int resultLocation) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        while (count < resultLocation) {
            stringBuilder.append("-");
            count++;
        }
        System.out.println(stringBuilder.toString());
    }
}

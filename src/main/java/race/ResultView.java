package race;

public class ResultView {

    protected static void printResult(String[] carDistance) {
        System.out.println(saveResult(carDistance));
    }

    protected static StringBuilder saveResult(String[] carDistance) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < carDistance.length) {
            sb.append(carDistance[index++]).append("\n");
        }
        return sb;
    }
}

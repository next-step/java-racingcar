package step3;

public class ResultView {

    public ResultView() {}

    public void printResult(int[][] results, InputDto inputDto) {
        System.out.println("\n실행 결과");

        for (int i = 0; i < inputDto.getNumberOfTrial(); i++) {
            for (int j = 0; j < inputDto.getNumberOfCar(); j++) {
                int number = results[i][j];
                String format = number > 0 ? "%" + number + "s" : "%s";
                System.out.println(String.format(format, "-").replace(" ", "-"));
            }
            System.out.println();
        }
    }
}

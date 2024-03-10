package racing;

import java.util.Scanner;

public class InputLayer {

    private static final Scanner scanner = new Scanner(System.in);

    public static void inputData(){
        int carCount = convertToInt(inputCarCount());
        int racingCount = convertToInt(inputRacingCount());
        ResultView resultView = new ResultView(new CarRacing(carCount, racingCount, new RandomFactory()));
        resultView.showView();
    }

    public static String inputCarCount() {
        System.out.println("자동차 대수는 몇대 인가요?");
        return scanner.nextLine();
    }

    public static String inputRacingCount() {
        System.out.println("시도할 횟수는 몇번인가요?");
        return scanner.nextLine();
    }

    public static int convertToInt(String text){
        try{
            return Integer.parseInt(text);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("정수 타입만 지원합니다.");
        }
    }
}

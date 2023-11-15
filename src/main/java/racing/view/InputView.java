package racing.view;

import java.util.Scanner;

public class InputView {
    private static final String QUESTION_MESSAGE_OF_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_MESSAGE_OF_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final String QUESTION_MESSAGE_OF_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ERROR_MESSAGE_OF_EXCEED_NAME_LENGTH = "자동차 이름 허용 길이를 초과하였습니다.";
    private static final int MAX_NAME_LENGTH = 5;

    private static final String SEPARATOR = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarCount(){
        System.out.println(QUESTION_MESSAGE_OF_CAR_COUNT);
        return scanner.nextInt();
    }

    public static String[] inputCarNames(){
        String carList = getCarList();
        return getSplitCarNames(carList);
    }

    public static String getCarList(){
        System.out.println(QUESTION_MESSAGE_OF_CAR_NAME);
        return scanner.nextLine();
    }

    public static String[] getSplitCarNames(String carList){
        return carList.split(SEPARATOR);
    }

    public static int inputTryCount(){
        System.out.println(QUESTION_MESSAGE_OF_TRY_COUNT);
        return scanner.nextInt();
    }
}

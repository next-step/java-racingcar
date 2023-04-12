package study;

public class InputView {
    private static final String GUIDE_FOR_INPUT_NUMBER_OF_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String GUIDE_FOR_INPUT_NUMBER_OF_GAME = "시도할 회수는 몇 회 인가요?";

    public static void guidForInputNumberOfCar(){
        System.out.println(GUIDE_FOR_INPUT_NUMBER_OF_CAR);
    }

    public static void guideForInputNumberOfGame(){
        System.out.println(GUIDE_FOR_INPUT_NUMBER_OF_GAME);
    }
}

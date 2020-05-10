package racingcar.view;

import racingcar.Car;

import java.util.Arrays;

public class ResultView {

    private static final String BANNER = "실행 결과";
    private ResultView(){
        throw new AssertionError();
    }

    public static void printBanner(){
        System.out.println(BANNER);
    }
    public static void printCarPositionPerRound(int[] positions){
        Arrays.stream(positions)
                .mapToObj(ResultView::convertStringPosition)
                .forEach(System.out::println);

    }

    private static String convertStringPosition(int position){
        String result = "-";
        for(int i=0; i<position; i++){
            result += result;
        }
        return result;
    }
}

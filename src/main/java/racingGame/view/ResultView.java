package racingGame.view;
import racingGame.dto.CarDto;
import racingGame.dto.CarsDto;

import java.util.List;

public class ResultView {

    private static final String MOVE_SIGN = "-";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String WINNER_MESSAGE = "가 최종 우승 했습니다.";
    private static final String SEPARATOR = ", ";
    private static final String CAR_NAME_SIGN = " : ";

    private ResultView(){

    }

    public static void resultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void racingWinner(List<String> winners){
        String winnerName = String.join(SEPARATOR, winners);
        System.out.println(winnerName + WINNER_MESSAGE);
    }

    public static void racingResult(CarsDto carsDto){
        for(CarDto carDto : carsDto.getCarsDto()){
            System.out.print(carDto.getName() + CAR_NAME_SIGN);
            System.out.print(carMoveStatus(carDto.getPosition()));
            System.out.println();
        }
        System.out.println();
    }

    private static String carMoveStatus(int move) {
        return MOVE_SIGN.repeat(move);
    }

}

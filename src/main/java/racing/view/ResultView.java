package racing.view;

import racing.domain.Car;
import racing.domain.dto.ResultDto;

public class ResultView {

    public static final String DASH = "-";

    public ResultView(ResultDto resultDto) {
        System.out.println("실행 결과");
        for (Car car : resultDto.getCars()){
            moveCarRecode(car);
        }
        showWinner(resultDto.findWinners());
    }

    private void moveCarRecode(Car car) {
        StringBuilder builder = new StringBuilder();
        builder.append(car.getName()).append(" : ");
        for(int i = 0; i < car.getMoveCount(); i++){
            builder.append(DASH);
        }
        System.out.println(builder.toString());
    }

    public void showWinner(String winners) {
        System.out.println(winners + " 가 최종 우승했습니다.");
    }
}

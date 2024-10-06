package study.racing;

import study.racing.strategy.MoveUnderOneDigitStrategy;

import java.util.List;
import java.util.Map;

public class RacingGame {

    public void racing() {

        InputView inputView = new InputView();

        int carCount = 0;
        int tryCount = 0;

        while(true) {
            carCount = inputView.input(RacingMessage.CAR_COUNT.getCode());
            tryCount = inputView.input(RacingMessage.TRY_COUNT.getCode());

            boolean isInputMatch = (carCount != 0 && tryCount != 0);
            if(!isInputMatch) {
                System.out.println(RacingMessage.TRY_COUNT.getMsg());
                return;
            }
            break;
        };

        PrepareForRacing prepareForRacing = new PrepareForRacing(new MoveUnderOneDigitStrategy());
        List<Map<Integer, Integer>> racingList = prepareForRacing.personalCarTotalCount(tryCount, carCount);

        for(int i= 0; i < racingList.size(); i++) {
            ResultView.printView(racingList.get(i));
        }
    }
}

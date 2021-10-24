package racingcar;

import racingcar.domains.Car;
import racingcar.utils.ParsingUtils;
import racingcar.utils.StringUtils;
import racingcar.views.InputView;

import java.util.List;
import java.util.Map;

public class RacingGame {

    private final String[] carNames;
    private final int round;
    private List<Car> cars;


    public RacingGame(Map<String, String> answerMap) {
        carNames = StringUtils.spliter(answerMap.get(InputView.QUESTION_NAMES));
        round = ParsingUtils.parseStringToInt(answerMap.get(InputView.QUESTION_ROUND));
    }


    public void race() {

        for (int i = 0; i < carNames.length; i++) {
            Car newCar = new Car(carNames[i]);
            cars.add(newCar);
        }

        //라운드 내에서 자동차 경주
            //라운드마다 자동차별로 다른 랜덤값 생성
            //랜덤값 4 이상일때만 자동차 전진하기
            //각 자동차별로 위치 저장하기기
        //각 라운드별, 각 자동차의 위치 출력하기
        //우승자 출력하기

    }

}

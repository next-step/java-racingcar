package com.hskim.nextstep.step03.ui;

import com.hskim.nextstep.step02.utils.StringUtils;
import com.hskim.nextstep.step03.model.RacingCar;

public class ResultView extends View {

    public String makeMoveProgressString(RacingCar racingCar) {

        /*
            간단한 String concatenation에는  StringBuilder가 필요하지 않다. 컴파일러 단에서 효율적으로 처리된다.
            StringBuilder -> + 로 refactor
         */
        return String.valueOf(racingCar.getCarNo()) +
                ". " +
                StringUtils.repeat("-", racingCar.moveForward(1));
    }
}

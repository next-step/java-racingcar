package racingcar.controller;

import racingcar.controller.extension.view.Viewable;
import racingcar.domain.response.RacingGamePlayResponse;

class TestView implements Viewable {

    private RacingGamePlayResponse racingGamePlayResponse;

    @Override
    public void draw(RacingGamePlayResponse racingGamePlayResponse) {
        this.racingGamePlayResponse = racingGamePlayResponse;
    }

    RacingGamePlayResponse getRacingGamePlayResponse(){
        return racingGamePlayResponse;
    }

}

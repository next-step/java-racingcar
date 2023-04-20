package study.step5.controller;

import study.step5.domain.RacingGameService;
import study.step5.domain.model.Track;
import study.step5.view.InputView;
import study.step5.view.ResultView;

public class RacingGameController {
    public static void main(String[] args) {
        //레이싱 경기장
        Track track = new RacingGameService().gameStart(InputView.askCarName(), InputView.aksAttemptCountCount());

        //레이싱 우승자 출력
        ResultView.outPutWinner(track);
    }
}

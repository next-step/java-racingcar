package racing.controller;

import racing.domain.RaceHistory;
import racing.service.RaceService;
import racing.view.InputView;
import racing.view.ResultView;


public class RaceController
{
    private static RaceController raceController;

    private final RaceService raceService;

    private RaceController(RaceService raceService)
    {
        this.raceService = raceService;
    }

    public static RaceController getInstance(RaceService raceService)
    {
        if (raceController == null)
        {
            raceController = new RaceController(raceService);
        }
        return raceController;
    }

    public void run()
    {
        RaceHistory raceHistory = raceService.gameStart(InputView.writeCarName(), getTryNumber());

        ResultView.draw(raceHistory);
        ResultView.winnerDraw(raceHistory);
    }

    private int getTryNumber()
    {
        int tryNumber = InputView.writeTryNumber();

        if (tryNumber <= 0)
        {
            throw new IllegalArgumentException("시도 횟수는 0이하 일 수는 없습니다.");
        }

        return tryNumber;
    }
}

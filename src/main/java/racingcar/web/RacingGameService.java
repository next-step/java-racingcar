package racingcar.web;

import racingcar.domain.RacingGame;
import racingcar.view.CarNameParser;
import racingcar.vo.RacingGameParameter;
import racingcar.vo.RacingResultOfRound;
import spark.Request;
import spark.Session;

import java.util.List;

public class RacingGameService {
    private static final String RACING_GAME = "racingGame";
    private static final int MINIMUM_ROUND = 1;

    public RacingResultOfRound race(Request request) {
        RacingGame racingGame = getRacingGame(request);
        RacingResultOfRound racingResult = racingGame.race();

        if (racingGame.isEnd()) {
            removeRacingGameFromSession(request.session());
        }

        return racingResult;
    }

    private RacingGame getRacingGame(Request request) {
        RacingGame racingGame = getRacingGameFromSession(request.session());

        if (null == racingGame) {
            racingGame = createNewRacingGame(request);
        }

        return racingGame;
    }

    private RacingGame createNewRacingGame(Request request) {
        String names = request.queryParams("names");
        List<String> carNames = CarNameParser.parseWhiteSpaceCarNamesString(names);

        String turn = request.queryParams("turn");
        int totalRound = Integer.parseInt(turn);
        totalRound = ((totalRound < MINIMUM_ROUND) ? MINIMUM_ROUND : totalRound);

        RacingGameParameter parameter = new RacingGameParameter(carNames, totalRound);
        RacingGame racingGame = new RacingGame(parameter);

        saveRacingGameInSession(racingGame, request.session());

        return racingGame;
    }

    public boolean isRacingEnd(Request request) {
        return null == getRacingGameFromSession(request.session());
    }

    private RacingGame getRacingGameFromSession(Session session) {
        return session.attribute(RACING_GAME);
    }

    public void saveRacingGameInSession(RacingGame racingGame, Session session) {
        session.attribute(RACING_GAME, racingGame);
    }

    public void removeRacingGameFromSession(Session session) {
        session.removeAttribute(RACING_GAME);
    }
}

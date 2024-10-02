package step5.game;

import step5.car.CarStrategy;
import step5.message.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PreparedCarGame {

    private GameStrategy gameStrategy;
    private final List<List<CarStrategy>> raceSituation = new ArrayList<>();

    public void ready(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    //레이싱을 시작한다.
    public void startRace() {
        checkRestart();
        for (int i = 0; i < this.gameStrategy.getAttemptNum(); i++) {
            this.gameStrategy.attemptForwardCar();
            this.raceSituation.add(copyCarStrategy());
        }
    }

    //레이싱의 우승자를 선별한다.
    public List<String> winnerRace() {
        checkStart();
        return this.gameStrategy.getWinners();
    }

    public List<List<CarStrategy>> getRaceSituation() {
        return raceSituation;
    }

    //레이싱 재시작하는지를 체크한다.
    private void checkRestart() {
        if (!this.raceSituation.isEmpty())
            throw new IllegalArgumentException(ExceptionMessage.GAME_ALREADY_START.message());
    }

    //시작을 했는지 안했는지 체크한다.
    private void checkStart() {
        if (this.raceSituation.isEmpty())
            throw new IllegalArgumentException(ExceptionMessage.GAME_NOT_START.message());
    }

    //CarStrategy 객체를 새로운주소로 copy한다.
    private List<CarStrategy> copyCarStrategy() {
        return this.gameStrategy.getRacingCars().stream()
                .map(CarStrategy::copy)
                .collect(Collectors.toList());
    }

}

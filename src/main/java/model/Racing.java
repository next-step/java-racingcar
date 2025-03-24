package model;

import java.util.ArrayList;
import java.util.List;

import ui.presenter.RacingConsoleUIPresenter;
import ui.presenter.RacingUIPresenter;

public class Racing {
    private final Participants participants;
    private int remainTryCount;
    private final RacingUIPresenter racingUIPresenter = new RacingConsoleUIPresenter();

    public Racing(String[] carNameList, int tryCount) {
        this.validate(carNameList, tryCount);
        this.remainTryCount = tryCount;

        List<Car> carList = new ArrayList<>();

        for (String s : carNameList) {
            carList.add(new Car(s, null));
        }

        participants = new Participants(carList);
    }

    private void validate(String[] carNameList, int tryCount) {
        if (carNameList == null) {
            throw new RuntimeException("carNameList는 null일 수 없습니다.");
        }

        if (carNameList.length == 0) {
            throw new RuntimeException("자동차 대수는 0 이상을 입력해주세요. carNameList : " + carNameList.length);
        }

        if (tryCount <= 0) {
            throw new RuntimeException("회수는 0 이상을 입력해주세요. tryCount : " + tryCount);
        }
    }

    private void moveOnce() {
        participants.moveAll();
        remainTryCount--;
    }

    public void moveUntilFinish() {
        while (isRemainTry()) {
            moveOnce();
            racingUIPresenter.printCurrentStatus(this);
        }
    }

    public boolean isRemainTry() {
        return this.remainTryCount > 0;
    }

    public List<Car> getWinner() {
        return this.participants.getWinner();
    }

    public List<Car> getCarList() {
        return this.participants.getParticipantList();
    }
}

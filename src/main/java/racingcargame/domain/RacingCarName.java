package racingcargame.domain;

import racingcargame.exception.WordCountException;

public class RacingCarName {
    private String name;

    public RacingCarName(String name) {
        this.name = name;
    }

    public void wordCountException(String name) throws WordCountException {
        if (name.length() > 5) {
            throw new WordCountException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
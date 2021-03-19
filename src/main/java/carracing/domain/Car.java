package carracing.domain;

import carracing.service.dto.RacingScore;
import common.utils.StringUtils;

import java.util.Random;

/**
 * Car
 * version 0.0.2
 * 
 * history
 *  0.0.1) 클래스 신규생성
 *  0.0.2) Engine 클래스 멤버필드 추가, drive 로직 수정
 *  0.0.3) name 필드 및 검증로직 추가
 */
public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final Engine engine = new Engine(new Random());

    private final String name;
    private int mileage;

    public Car(String name) {
        validate(name);
        String trimmedName = name.trim();
        validateTrimmedName(trimmedName);
        this.name = trimmedName;
    }

    private void validate(String name) {
        if(StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 최소 1자 이상 입력되어야 합니다.");
        }
    }

    private void validateTrimmedName(String trimmedName) {
        if(trimmedName.length()>MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void drive() {
        mileage+=engine.drive();
    }

    public String getName() {
        return name;
    }

    public boolean isWinner(int score) {
        return mileage >= score;
    }

    public int calculateWinnerScore(int score) {
        return Math.max(mileage, score);
    }

    public RacingScore inquiryRacingScore() {
        return new RacingScore(name, mileage);
    }
}

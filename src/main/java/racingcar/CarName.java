package racingcar;

/**
 * 자동차 이름 클래스
 */
public class CarName {

    private String name;    // 자동차 이름

    public CarName(String name) {
        // 유효성 검사
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

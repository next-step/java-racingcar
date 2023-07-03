package racingcar.domain.extension;

/**
 * Car 클래스가 움직여야 하는지 판단하는 인터페이스 입니다.
 */
public interface Moveable {

    /**
     * Car 가 움직여야 하는지 반환합니다.
     *
     * @return boolean true면 움직임, false면 움직이지 않음
     */
    boolean isMove();

}

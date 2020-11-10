package racingcar.domain.exception;

public class AlreadyTerminateRaceGameException extends RuntimeException{

    private static final String MESSAGE = "이미 레이스가 종료된 게임입니다. 게임을 시작할 수 없습니다.";
    public AlreadyTerminateRaceGameException(){
        super(MESSAGE);
    }
}

package racing.exception;

public class EmptyInputDataException extends IllegalArgumentException {
	public EmptyInputDataException() {
		super("입력한 데이터가 없습니다. 필수 입력 요소이므로 입력하지 않으면 진행할 수 없습니다.");
	}
}

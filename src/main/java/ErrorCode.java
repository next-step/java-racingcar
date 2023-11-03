public enum ErrorCode {
	ILLEGAL_ARGUMENT_EXCEPTION("부적절한 파라미터 입니다."),
	;

	private final String message;

	ErrorCode(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

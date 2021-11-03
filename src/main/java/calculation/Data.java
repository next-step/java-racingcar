package calculation;

public class Data {
	private static final String NULL_ERROR_MESSAGE = "error : null 값은 사용할수 없습니다.";
	private static final String EMPTY_ERROR_MESSAGE = "error : 공백은 사용할수 없습니다.";
	private final String[] data;

	public Data(String data) {
		checkNull(data);
		checkEmpty(data);
		this.data = emptyDataSplit(data);
	}

	private void checkNull(String value) {
		if (value == null) {
			throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
		}
	}

	private void checkEmpty(String value) {
		if (value.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
		}
	}

	private String[] emptyDataSplit(String data) {
		return data.split(" ");
	}

	public int size() {
		return data.length;
	}

	public String value(int index) {
		return data[index];
	}

	public String[] getData() {
		return data;
	}
}

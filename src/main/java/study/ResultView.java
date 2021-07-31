package study;

public class ResultView {

	private int carCount;
	private int executionCount;

	public void getResultComment() {
		System.out.println("실행 결과");
	}

	public void setValues(int carCount, int executionCount) {
		this.carCount = carCount;
		this.executionCount = executionCount;
	}


}

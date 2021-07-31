package study;

import java.util.Map;

public class ResultView {

	public void getResultComment() {
		System.out.println("실행 결과");
	}

	public void startResultView(Map<Integer, String> carContainer) {
		for(int i = 1 ; i <= carContainer.size() ; ++i) {
			System.out.println(carContainer.get(i));
		}
		System.out.println();
	}
}

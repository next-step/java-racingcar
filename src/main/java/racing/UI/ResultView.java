package racing.UI;

import java.util.ArrayList;

public class ResultView {

	public void printTitle() {
		System.out.println();
		System.out.println("실행 결과");
	}

	public void print(ArrayList<Integer> carPositions) {
		for (int pos : carPositions) {
			System.out.println("|"+printUnit(pos));
		}
		System.out.println();
	}
	
	private String printUnit(int moves) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < moves; ++i) {
			result.append("-");
		}
		return result.toString();
	}
}

package step2;

import step2.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
	private ResultView resultView;
	private int[] carPositions;
	List<int[]> carPositionsList;
	private int time;    // 이동 횟수
	private Random rnd = new Random();

	public RacingGame(int carNum, int time) {
		validate(carNum, time);
		carPositions = new int[carNum];
		carPositionsList = new ArrayList<>();
		addCarPositions(carPositions.clone());

		this.time = time;
		resultView = new ResultView();
	}

	public int[] getCarPositions() {
		return carPositions;
	}

	public List<int[]> getCarPositionsList() {
		return carPositionsList;
	}

	// 유효성 체크
	private void validate(int carNum, int time) {
		if (carNum < 1) {
			throw new IllegalArgumentException("차량 수 오류");
		}

		if (time < 1) {
			throw new IllegalArgumentException("횟수 오류");
		}
	}

	// 실행
	public void run() {
		for (int i = 0; i < time; i++) {
			move();
		}
		resultView.showResult(carPositionsList);
	}

	// 이동
	private void move() {
		for (int i = 0, iLen = carPositions.length; i < iLen; i++) {
			carPositions[i] += getDistance();
		}

		addCarPositions(carPositions.clone());
	}

	// 차량 위치 저장
	public void addCarPositions(int[] carPositions) {
		carPositionsList.add(carPositions);
	}

	// 이동 거리 생성
	private int getDistance() {
		return getRandomNum() >= 4 ? 1 : 0;
	}

	// 0~9 숫자 생성
	public int getRandomNum() {
		return rnd.nextInt(10);
	}
}

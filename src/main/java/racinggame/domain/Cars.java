package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racinggame.dto.GameResultDto;
import racinggame.dto.MoveResultDto;
import racinggame.dto.RoundResultDto;

public class Cars {
	private final static int CAR_NAME_LENGTH = 5;

	private final List<Car> carList = new ArrayList<>();

	public void createCarsWithCarNames(String carNames) {
		isEmptyOrNullCarName(carNames);
		String[] carNamesArray = carNames.split(",");
		isValidCarNames(carNamesArray);
		for (String carName : carNamesArray) {
			carList.add(new Car(carName, new RandomMoveStrategy()));
		}
	}

	private void isEmptyOrNullCarName(String carName) {
		if (carName == null || carName.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
		}
	}

	private void isValidCarName(String carName) {
		if (carName == null || carName.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
		}

		if (carName.length() > CAR_NAME_LENGTH) {
			throw new IllegalArgumentException("자동차 이름 길이는 5자 이하만 가능합니다.");
		}
	}

	private void isValidCarNames(String[] carNamesArray) {
		for (String carName : carNamesArray) {
			isValidCarName(carName);
		}
	}

	private RoundResultDto raceOneRound(List<Car> carList) {
		List<MoveResultDto> moveResultDtoList = new ArrayList<>();
		for (Car car : carList) {
			car.move();
			moveResultDtoList.add(new MoveResultDto(car.getName(), car.getPosition()));
		}
		return new RoundResultDto(moveResultDtoList);
	}

	public GameResultDto startRacing(int moveCount) {
		List<RoundResultDto> roundResultDtoList = new ArrayList<>();
		for (int i = 0; i < moveCount; i++) {
			roundResultDtoList.add(raceOneRound(carList));
		}
		return new GameResultDto(getWinnerNames(roundResultDtoList), roundResultDtoList);
	}

	private int getMaxPosition(RoundResultDto lastRoundResultDto) {
		int maxPosition = 0;
		for (MoveResultDto moveResultDto : lastRoundResultDto.getRoundResult()) {
			maxPosition = Math.max(maxPosition, moveResultDto.getPosition());
		}
		return maxPosition;
	}

	private String getWinnerNames(List<RoundResultDto> roundResultDtoList) {
		int maxPosition = getMaxPosition(roundResultDtoList.get(roundResultDtoList.size()-1));
		return roundResultDtoList.get(roundResultDtoList.size()-1).getRoundResult().stream()
			.filter(mr -> mr.isEqualPosition(maxPosition))
			.map(MoveResultDto::getName)
			.collect(Collectors.joining(", "));
	}
}

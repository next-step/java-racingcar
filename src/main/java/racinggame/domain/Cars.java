package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racinggame.dto.GameResultDto;
import racinggame.dto.MoveResultDto;
import racinggame.dto.RoundResultDto;

public class Cars {
	private final List<Car> carList;

	public Cars(String[] carNamesArray) {
		isValidCarNames(carNamesArray);
		carList = new ArrayList<>();
		for (String carName : carNamesArray) {
			carList.add(new Car(carName, new RandomMoveStrategy()));
		}
	}

	private void isValidCarName(String carName) {
		if (carName == null || carName.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
		}

		if (carName.length() > 5) {
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

	private String getWinnerNames(List<RoundResultDto> roundResultDtoList) {
		int maxPosition = getMaxPosition(roundResultDtoList.get(roundResultDtoList.size()-1));
		return roundResultDtoList.get(roundResultDtoList.size()-1).getRoundResult().stream()
			.filter(mr -> mr.isEqualPosition(maxPosition))
			.map(MoveResultDto::getName)
			.collect(Collectors.joining(", "));
	}

	private int getMaxPosition(RoundResultDto lastRoundResultDto) {
		int maxPosition = 0;
		for (MoveResultDto moveResultDto : lastRoundResultDto.getRoundResult()) {
			maxPosition = Math.max(maxPosition, moveResultDto.getPosition());
		}
		return maxPosition;
	}
}

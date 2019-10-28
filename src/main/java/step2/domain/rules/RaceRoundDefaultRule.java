package step2.domain.rules;

public class RaceRoundDefaultRule extends RaceRoundRule {

	private static int MIN_RACE_ROUND = 1;

	public RaceRoundDefaultRule(int raceRoundNumber) {
		super(raceRoundNumber);
	}

	@Override
	public int validate(int raceRoundNumber) {
		if (raceRoundNumber < MIN_RACE_ROUND) {
			throw new IllegalArgumentException(
					String.format("자동차 경기 횟수는 %s회 미만일 수 없습니다. 입력해주신 경기 횟수(%s)를 확인해주세요!",
							MIN_RACE_ROUND, raceRoundNumber));
		}
		return raceRoundNumber;
	}

}

package simpleracing.domain.game;

import simpleracing.domain.tools.CarRacingResult;

public interface CarGame {
	CarRacingResult play(int numberOfAttempts);
}

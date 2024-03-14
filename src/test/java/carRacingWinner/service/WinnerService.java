package carRacingWinner.service;

import carRacingWinner.repository.WinnerRepository;

public class WinnerService {
    private final WinnerRepository winnerRepository;

    public WinnerService(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }
}

package carRacingWinner.service;

import carRacingWinner.repository.WinnerRepository;

public class WinnerService {
    private final WinnerRepository winnerRepository;
    private final String splitWord = "-";


    public WinnerService(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }

    private String[] division(String names) {
        String[] words = names.split(splitWord);
        for (String word : words) {
            if (lengthCheck(word))
                throw new IllegalArgumentException("길이가 깁니다");
        }
        return words;
    }

    public void makeCars(String input) {
        winnerRepository.makeCars(division(input));
    }

    private boolean lengthCheck(String name) {
        return name.length() > 5;
    }

    public void tryCount(String input) {
        int cnt = Integer.parseInt(input);
        if (cnt < 0)
            throw new IllegalArgumentException("잘못된 시도 횟수 입니다");
        winnerRepository.tryCount(cnt);
    }

    public void play() {
        System.out.println("실행 결과");
        int Try = winnerRepository.getTryCount();
        while (Try >= 0) {
            winnerRepository.currentLocation();

            Try--;
        }
    }
}

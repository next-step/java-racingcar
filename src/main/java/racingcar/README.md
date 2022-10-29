# 구현 기능 목록
1. Car.move는 0~9 사이의 입력 값을 받고 값이 4이상 9 이하일 때 현재 위치(position)를 1만큼 증가 시킨다.
2. Car.toString은 car의 position에 상응하는 문자열을 리턴한다. ex)position이 1인경우 -> -, position이 5인경우 -> -----
3. RacingGame.startGame(자동차 대수, 게임 횟수) : 자동차 대수 만큼 Car 객체 생성, 각객체에 대해 move(랜덤 값).toString() 호출, 게임 횟수 만큼 반복
4. RacingGameView 클래스에서 안내 메시지를 출력하고 대수, 회수를 입력받아 RacingGame.startGame을 호출한다. 
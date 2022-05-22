# 자동차 경주 게임 구현 기능(STEP4)
1) INPUT VIEW) 입력받은 이름 공백 제거
2) carNameValidation) 자동차이름 입력시 5자 이상일 경우만 생성 가능
3) carNameValidation) 입력받은 carName 쉼표(,)로 구분하여 CarNames 배열 만들기
4) CARS) 입력받은 이름으로 자동차 생성
5) CARS) 현재 자동차들의 MAX값 구하기
6) CARS) 자동차들의 MaxPosition을 저장
7) RacingGame) Position이 MAX인 자동차이름 찾기
8) RacingGame) 우승자에 자동차이름을 저장
9) ResultView) 현재 이동거리 및 우승자 출력

TestCase
1) carNameValidation) 자동차 이름 빈 값 들어올 경우 에러
2) carNameValidation) 자동차 이름 5자 이상일 경우 에러

# Step3 - FeedBack
+) 상수 > 인스턴스 변수 순으로 선언(O)
+) 자동차 클래스가 랜덤한 수 생성하는 책임까지 가질 필요 x, 랜덤한 수 책임 따로 분리해보기(O)
+) RacingGame > createCar 메소드 Cars 클래스의 책임에 더 알맞음(O)

+) moveOrStop 메소드 (랜덤값 입력 받아 전진여부 판단, 테스트 추가) >> 바꾸긴했는데 테스트 방법 (?)

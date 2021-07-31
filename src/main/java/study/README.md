자동차 경주 Step 3

1. 역할을 책임지는 클래스를 생성한다.
2. InputView에 carCount와 executionCount를 초기화 및 getter 메소드를 작성한다. 
3. ResultView를 작성한다. 
4. AutomobileRaceService를 작성한다.
5. AutomobileRace를 작성하고 ResultView의 역할을 더 줄여준다.


2번째 리팩토링

1. NumberContainer를 생성한다. 그 역할은 랜덤인 숫자를 제공하는 것이다.
2. Car를 생성한다.
3. inputView로 입력받은 CarCount를 이용하여 Car를 생성한다.
4. 경기장 Stadium 을 생성하고 역할을 부여한다. 그리고 ResultView의 역할도 부여한다.
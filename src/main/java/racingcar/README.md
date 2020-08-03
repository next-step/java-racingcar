## **자동차 경주**

#### [요구사항]
##### 구현 목적
###### n대의 자동차, 각 m번의 이동 시행을 하는 자동차 경주 게임 구현
##### 설계 요구 사항
          1. 주어진 (이동 시행)횟수 안에 n대의 자동차 각 (전진 || 멈춤)
          2. 사용자 입력 (n : 자동차 대수, m : 이동 시행 횟수)
          3. 1.의 전진은 조건부 (0~9 사이 random값 구한 후, 그 random갑 >= 4)
          4. 자동차 상태(누적 이동 시행) 화면에 출력, 단 어느 시점에 출력할 것인지 제약은 없음 
(질문) : SampleCase 각각 4회, 4회, 5회 이동내역? 4. 시점 관련 이해 못함
###### 힌트
`Scanner scanner = new Scanner(System.in);
 String value = scanner.nextLine(); 
 int number = scanner.nextInt();`  
 `int randomNum = java.util.Random.nextInt(10);`
##### 구현 요구 사항 
          1. 모든 로직에 단위 테스트 구현
             (단, 입출력 UI 로직은 제외)
             1.1 핵심 로직 구현 코드와 UI 담당 로직 구분
             1.2 UI 로직 : InputView, ResultView 클래스 추가해 분리
          2. 자바 코드 컨벤션 지키며 프로그래밍
          3. else 예약어 사용 X
             switch/case문도 사용 X 
             HINT : if (조건절) { } return null;

##### 기능 목록 
        Day 1
            * domain = 객체 
                domain.Car
                //domain.Constants
            * strategy = 핵심 (경주) 로직
                strategy.RacingStrategy
                strategy.ForwardStrategy
           * view = UI 로직
                view.InputView
                view.ResultView

##### commit 단위 : "(구분자) 기능목록"
        * feat = feature
        * fix = bug fix
        * docs = documentation
        * style = formatting, missing semi colons,..
        * refactor
        * test = when adding missing tests
        * chore = maintain 
        
##### 코드 리뷰 내역
         Day 1
            * 
         
         Day 2
            * 
            
            
         
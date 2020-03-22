# racing game 요구사항 기능 정리

**RacingApplication**
1. 사용자에게 2 개의 정수를 입력 받는다. (scanner 이용)
    1. 입력값1 : 자동차의 수
    1. 입력값2 : 이동 수

**Car**
1. 자동차 번호 필드
1. 움직이는 거리 필드
1. 자동차 이름 필드
1. 게임 진행시 자동차 이동

**NumberUtil** (NumberVo > NumberUtil 로 이름 수정)
1. 0~9 사이의 random 값을 구하는 기능
1. 값이 정수 인지 체크
1. String을 int로 변환, 반환, 검증
1. 값이 1 이상인치 체크
1. 값이 4 이상인치 체크
    
**Racing**
1. Car의 List 필드
1. 게임 수 만큼 자동차 이동

**InputView**
1. Car의 수 필드
1. Racing game 수 필드   
1. 자동차 이름 필드
1. 입력값이 validate

**ResultView**
1. "-" 상수
1. Car의 이동 거리 만큼 - 표기

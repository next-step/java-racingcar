# racing game 요구사항 기능 정리

**RacingApplication**
1. 사용자에게 2 개의 정수를 입력 받는다. (scanner 이용)
    1. 입력값1 : 자동차의 수
    1. 입력값2 : 이동 수

**Position**
* 이동거리를 +1 한다
1. 정렬

**Car**
1. 게임 진행시 자동차 이동

**RacingCars**
1. 레이싱을 진행하는 car들의 collection
1. 모든 자동차를 이동

**NumberUtil** (NumberVo > NumberUtil 로 이름 수정)
1. 0~9 사이의 random 값을 구하는 기능
1. 값이 정수 인지 체크
1. String을 int로 변환, 반환, 검증
1. 값이 1 이상인치 체크
1. 값이 4 이상인치 체크
    
**Racing**
1. Car의 List 필드
1. 레이싱 1 라운드를 진행
1. 전체 라운드 수 만큼 자동차 이동
1. 라운드 결과 저장
1. 우승자 찾기

**InputView**
1. 입력값 validate
1. Racing에서 사용 가능 하도록 입력값 변환 및 저장

**ResultView**
1. "-" 상수
1. 입력 크기 만큼 '-' 표기
1. 한 라운드의 이동 거리 표기
1. 전체 라운드의 이동거리 표기
1. 우승자 표기

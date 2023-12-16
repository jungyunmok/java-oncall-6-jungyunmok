package oncall.model;

import java.util.List;

public class Schedule {
    // 연속으로 근무하는 사원이 있을 경우 예외처리
    public void validateWorker(List<String> workerList) {
        for (int i = 0; i < workerList.size()-1; i++) {
            if(workerList.get(i).equals(workerList.get(i+1))) {
                System.out.println("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
                throw new IllegalArgumentException();
            }
        }
    }

    // 근무자 평일, 휴일 비상 근무자 편성하기

    // 근무자 재편성하기 - 평'휴인 경우 휴일근무자, 휴'평인 경우 평일근무자와 교대
}

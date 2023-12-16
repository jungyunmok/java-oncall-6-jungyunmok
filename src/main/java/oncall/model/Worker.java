package oncall.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Worker {
    // 근무자 이름 담아서 반환
    public List<String> checkWorker(String names) {
        if(names.length() < 5 || !names.contains(",")) {
            System.out.println("[ERROR] 사원 닉네임은 쉼표로 구분하여 최소 5명, 최대 35명 입력해주세요.");
            throw new IllegalArgumentException();
        }
        String[] tempList = workerArrayException(names);
        if(tempList.length < 5 || tempList.length > 35) {
            System.out.println("[ERROR] 사원 닉네임은 쉼표로 구분하여 최소 5명, 최대 35명 입력해주세요.");
            throw new IllegalArgumentException();
        }
        List<String> workerList = checkNames(tempList);
        return workerList;
    }

    // 근무자 배열 예외처리
    private String[] workerArrayException(String names) {
        String[] tempStr;
        try {
            String tempLast = String.valueOf(names.charAt(names.length() - 1));
            if(tempLast.equals(",")) {
                throw new ArrayIndexOutOfBoundsException();
            }
            tempStr = names.split(",");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[ERROR] 사원 닉네임은 쉼표로 구분하여 최소 5명, 최대 35명 입력해주세요.");
            throw new IllegalArgumentException(e);
        }
        return tempStr;
    }

    // 근무자 닉네임 유효성 확인
    private List<String> checkNames(String[] tempList) {
        List<String> nameList = Arrays.asList(tempList);
        for (int i = 0; i < nameList.size(); i++) {
            if(nameList.get(i).length() < 1 || nameList.get(i).length() > 5 || Collections.frequency(nameList, nameList.get(i)) > 1) {
                System.out.println("[ERROR] 사원 닉네임은 중복되지 않게 최대 5글자로 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }
        return nameList;
    }

    // 평일과 휴일에 각각 1번씩 편성되었는지 확인
    public void checkSameWorker(List<String> weekdayList, List<String> weekendList) {
        for(String name : weekdayList) {
            if(!weekendList.contains(name)) {
                System.out.println("[ERROR] 비상 근무자는 평일 순번, 휴일 순번에 각각 1회 편성되야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    // 연속으로 근무하는 사원이 있을 경우 예외처리
    public void validateWorker(List<String> workerList) {
        for (int i = 0; i < workerList.size() - 1; i++) {
            if (workerList.get(i).equals(workerList.get(i + 1))) {
                throw new IllegalArgumentException();
            }
        }
    }
}

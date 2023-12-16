package oncall.model;

import java.util.List;

public class Schedule {
    // 근무자 평일, 휴일 비상 근무자 편성하기
    public List<String> makeSchedule(List<String> monthInfo, List<String> weekdayWorker, List<String> weekendWorker) {
        int weekendIndex = 0;
        int weekdayIndex = 0;
        for (int i = 0; i < monthInfo.size(); i++) {
            if (monthInfo.get(i).contains("토") || monthInfo.get(i).contains("일") || monthInfo.get(i).contains("휴일")) {
                monthInfo = changeSchedule(i, monthInfo, weekendWorker, weekendIndex);
                weekendIndex++;
                continue;
            }
            monthInfo = changeSchedule(i, monthInfo, weekdayWorker, weekdayIndex);
            weekdayIndex++;
        }
        return monthInfo;
    }

    // 연속 근무자 재편성하기 - 평(어제)'휴(오늘)인 경우 휴일근무자, 휴(어제)'평(오늘)인 경우 평일근무자와 교대
    private List<String> changeSchedule(int index, List<String> monthInfo, List<String> workerList, int workerndex) {
        String beforeToday = "";
        if (index > 0) {
            beforeToday = monthInfo.get(index - 1);
        }
        String todayWorker = workerList.get(workerndex);
        if (beforeToday.equals(todayWorker)) {
            String nextWorker = workerList.get(workerndex + 1);
            workerList.set(workerndex, nextWorker);
            workerList.set(workerndex, todayWorker);
        }
        monthInfo.set(index, monthInfo.get(index) + " " + workerList.get(workerndex));
        return monthInfo;
    }
}

package oncall.model;

import java.util.List;

public class Schedule {
    // 근무자 평일, 휴일 비상 근무자 편성하기
    public List<String> makeSchedule(List<String> monthInfoTemp, List<String> weekdayWorker, List<String> weekendWorker) {
        int weekendIndex = 0;
        int weekdayIndex = 0;
        List<String> monthInfo = monthInfoTemp;
        for (int i = 0; i < monthInfo.size(); i++) {
            if (weekendIndex < weekendWorker.size() && (monthInfo.get(i).contains("토") || monthInfo.get(i).contains("일") || monthInfo.get(i).contains("휴일"))) {
                monthInfo = changeScheduleWeekend(i, monthInfo, weekdayWorker, weekendWorker, weekdayIndex, weekendIndex);
                weekendIndex++;

            } else if(weekdayIndex < weekdayWorker.size() && (!monthInfo.get(i).contains("토") && !monthInfo.get(i).contains("일") && !monthInfo.get(i).contains("휴일"))) {
            monthInfo = changeScheduleWeekday(i, monthInfo, weekdayWorker, weekendWorker, weekdayIndex, weekdayIndex);
            weekdayIndex++;
            }
        }
        return monthInfo;
    }

    // 연속 근무자 재편성하기 - 휴(어제)'평(오늘)인 경우 평일근무자와 교대
    private List<String> changeScheduleWeekday(int index, List<String> monthInfo, List<String> weekdayWorker, List<String> weekendWorker, int weekdayIndex, int weekendIndex) {
        if (index > 0 && monthInfo.get(index - 1).contains(weekendWorker.get(weekendIndex))) {
            String beforeToday = weekendWorker.get(weekendIndex);
            if(weekendIndex > 1) beforeToday = weekendWorker.get(weekendIndex - 1);
            String todayWorker = weekdayWorker.get(weekdayIndex);
            if (beforeToday.equals(todayWorker)) {
                String nextWorker = weekdayWorker.get(weekdayIndex + 1);
                weekdayWorker.set(weekdayIndex, nextWorker);
                weekdayWorker.set(weekdayIndex + 1, todayWorker);
            }
        }
        monthInfo.set(index, monthInfo.get(index) + " " + weekdayWorker.get(weekdayIndex));
        return monthInfo;
    }

    // 연속 근무자 재편성하기 - 평(어제)'휴(오늘)인 경우 휴일근무자
    private List<String> changeScheduleWeekend(int index, List<String> monthInfo, List<String> weekdayWorker, List<String> weekendWorker, int weekdayIndex, int weekendIndex) {
        if (index > 0 && monthInfo.get(index - 1).contains(weekdayWorker.get(weekdayIndex))) {
            String beforeToday = weekdayWorker.get(weekdayIndex);
            if(weekdayIndex > 0) beforeToday = weekdayWorker.get(weekdayIndex - 1);
            String todayWorker = weekendWorker.get(weekendIndex);
            if (beforeToday.equals(todayWorker)) {
                String nextWorker = weekendWorker.get(weekendIndex + 1);
                weekendWorker.set(weekendIndex, nextWorker);
                weekendWorker.set(weekendIndex + 1, todayWorker);
            }
        }
        monthInfo.set(index, monthInfo.get(index) + " " + weekendWorker.get(weekendIndex));
        return monthInfo;
    }
}

package oncall.view;

import java.util.List;

public class OutputVIew {
    // 비상 근무표 출력
    public void printSchedule(List<String> scheduleResult) {
        for(String schedule : scheduleResult) {
            System.out.println(schedule);
        }
    }
}

package top.mores.timeLimitedTrial.TimeUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    /**
     * 返回截止时间
     * @param time 小时
     * @return 当前系统时间+小时=截止时间
     */
    public String getEndTime(Integer time) {
        if (time == null || time <= 0) {
            return "Invalid Time";
        }

        LocalDateTime endTime = LocalDateTime.now().plusHours(time);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm");
        return endTime.format(formatter);
    }

    /**
     * 是否过期判断
     * @param endTimeStr 时间
     * @return Y/N
     */
    public boolean isExpired(String endTimeStr) {
        if (endTimeStr == null || endTimeStr.isEmpty()) return true;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm");
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, formatter);

        return endTime.isBefore(LocalDateTime.now());
    }

}

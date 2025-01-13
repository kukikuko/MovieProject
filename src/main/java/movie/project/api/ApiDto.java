package movie.project.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Getter
@Setter
@Builder
@ToString
public class ApiDto {

    private Long rank;
    private Long id;
    private String title;
    private Date openDt;

    public static ApiDto makeDto(JSONObject item) {
        return ApiDto.builder().
                rank(Long.valueOf((String)item.get("rank"))).
                id(Long.valueOf((String)item.get("movieCd"))).
                title((String)item.get("movieNm")).
                openDt(parseDate((String)item.get("openDt"))).
                build();
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (Exception e) {
            log.error("에러 {0}", e);
            return null;
        }
    }
}

package movie.project.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ApiService {

    @Value("${movie.api.key}")
    private String key;

    private final ApiRepository apiRepository;
    RestTemplate restTemplate = new RestTemplate();

    @Transactional
    public void fetchDataFromApi() throws ParseException {
        String baseUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=";
        String targetDt = "&targetDt="+ LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        String url = baseUrl + key + targetDt;
        String jsonString = restTemplate.getForObject(url, String.class);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
        JSONObject jsonResponse = (JSONObject) jsonObject.get("boxOfficeResult");
        JSONArray jsonItems = (JSONArray) jsonResponse.get("dailyBoxOfficeList");

        List<ApiDto> result = new ArrayList<>();
        for(Object o : jsonItems) {
            JSONObject item = (JSONObject) o;

            ApiDto apiDto = ApiDto.makeDto(item);
            result.add(apiDto);
        }
        apiRepository.saveAll(result);
    }
}

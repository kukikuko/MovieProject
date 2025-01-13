package movie.project.api;

import lombok.RequiredArgsConstructor;
import movie.project.mapper.ApiMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApiRepository {

    private final ApiMapper apiMapper;

    public void saveAll(List<ApiDto> result) {
        apiMapper.saveAll(result);
    }
}

package movie.project.mapper;

import movie.project.api.ApiDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApiMapper {
    void saveAll(List<ApiDto> apiDto);
}

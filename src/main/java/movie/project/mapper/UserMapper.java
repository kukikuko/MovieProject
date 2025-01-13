package movie.project.mapper;

import movie.project.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int save(User user);
    List<User> findAll();
}

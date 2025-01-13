package movie.project.repository;

import lombok.RequiredArgsConstructor;
import movie.project.domain.User;
import movie.project.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MybatisUserRepository implements UserRepository {

    private final UserMapper userMapper;

    @Override
    public int save(User user) {
        return userMapper.save(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}

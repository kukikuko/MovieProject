package movie.project.repository;

import movie.project.domain.User;

import java.util.List;

public interface UserRepository {
    int save(User user);
    List<User> findAll();
}

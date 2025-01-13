package movie.project.domain;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String userId;
    private String password;
    private String userName;
    private String email;
    private String phoneNumber;
    private Role role;
    private Grade grade;

}

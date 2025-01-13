package movie.project.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import movie.project.domain.Grade;
import movie.project.domain.Role;

public class UserDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {

        private Long id;

        @NotBlank
        private String userId;
        @NotBlank
        private String password;
        @NotBlank
        private String userName;
        @NotBlank
        private String email;
        @NotBlank
        private String phoneNumber;

        private Role role;
        private Grade grade;
    }
}

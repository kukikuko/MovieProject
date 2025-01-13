package movie.project.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Grade {
    WHITE("GRADE_WHITE"),
    GOLD("GRADE_GOLD"),
    VIP("GRADE_VIP");

    private final String value;
}

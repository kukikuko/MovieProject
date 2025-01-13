package movie.project.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import movie.project.repository.MybatisUserRepository;
import movie.project.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MybatisUserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @PostMapping("/join")
    public String homePost(@ModelAttribute User user) {
        int result = userRepository.save(user);
        log.info("saveUser: {}", result);
        return "redirect:/";
    }

    @GetMapping("/join")
    public String join(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "join";
    }

}

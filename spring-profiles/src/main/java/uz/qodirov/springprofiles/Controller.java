package uz.qodirov.springprofiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${profile.name}")
    private String profile;

    @GetMapping("/get_profile")
    public String getProfiles() {
        return profile;
    }
}

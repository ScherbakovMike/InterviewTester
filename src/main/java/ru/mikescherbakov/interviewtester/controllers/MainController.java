package ru.mikescherbakov.interviewtester.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mikescherbakov.interviewtester.models.HTMLHelper;
import ru.mikescherbakov.interviewtester.models.PageSettings;
import ru.mikescherbakov.interviewtester.repo.PageSettingsRepository;

import java.util.Objects;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private PageSettingsRepository settingsRepository;

    @GetMapping("/")
    public String greeting(Model model) {
        PageSettings settings = settingsRepository.findByName("index");

        if (Objects.nonNull(settings)) {
            model.addAttribute("title", settings.getTitle());
            return "index_template";
        } else
            return "error_pages/404";
    }

    @GetMapping("/catalog/update")
    public String catalogUpdate(Model model) {
        HTMLHelper.updateCatalog();
        return "index_template";
    }
}
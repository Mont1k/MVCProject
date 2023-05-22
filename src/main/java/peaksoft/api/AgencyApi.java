package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Agency;
import peaksoft.exception.MyException;
import peaksoft.service.AgencyService;

@Controller
@RequestMapping("/agencies")
@RequiredArgsConstructor
public class AgencyApi {
    private final AgencyService agencyService;
    @GetMapping
    public String getAllAgency(Model model){
        model.addAttribute("agencies", agencyService.getAllAgency());
        return "mainPage";
    }
    @GetMapping("/new")
    public String createAgency(Model model){
        model.addAttribute("newAgency", new Agency());
        return "newAgency";
    }
    @PostMapping("/save")
    public String  saveAgency(@ModelAttribute("newAgency") Agency agency) throws MyException {
        agencyService.saveAgency(agency);
        return "redirect:/agencies";
    }
    @DeleteMapping("/{id}")
    public String deleteAgency(@PathVariable("id") Long id){
        agencyService.deleteAgency(id);
        return "redirect:agencies";
    }
}
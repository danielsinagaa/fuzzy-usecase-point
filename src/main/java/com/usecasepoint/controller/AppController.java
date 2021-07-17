package com.usecasepoint.controller;

import com.usecasepoint.entity.*;
import com.usecasepoint.entity.enumcons.EFEnum;
import com.usecasepoint.entity.enumcons.Login;
import com.usecasepoint.entity.enumcons.TCFEnum;
import com.usecasepoint.model.MetricsShow;
import com.usecasepoint.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private MetricService metricService;

    @Autowired
    private ProyekService proyekService;

    @Autowired
    private AktorService aktorService;

    @Autowired
    private UseCaseService useCaseService;

    @Autowired
    private TCFService tcfService;

    @Autowired
    private EFService efService;

    private Login userLogin = new Login("admin","password",false,"");

    @GetMapping("/result")
    public String result(Model model){
        if (!userLogin.getLogin()){
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }

        List<MetricsShow> metricsShows = new ArrayList<>();

        metricService.findAll().forEach(it ->
                metricsShows.add(new MetricsShow(it)));

        model.addAttribute("metricsList", metricsShows);
        return "result";
    }

    @GetMapping("/project")
    public String project(Model model){
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        model.addAttribute("proyeksList", proyekService.findAll());
        return "project";
    }

    @GetMapping("/deleteProyek/{id}")
    public String deleteProyek(@PathVariable (value = "id") String id) {

        proyekService.deleteByProyek(id);
        return "redirect:/project";
    }

    @GetMapping("/deleteMetrics/{id}")
    public String deleteMetrics(@PathVariable (value = "id") String id) {

        metricService.deleteByMetrics(id);
        return "redirect:/result";
    }

    @PostMapping("/saveproyek")
    public String saveProyek(@ModelAttribute("proyek")Proyek proyek) {
        proyekService.save(proyek);
        return "redirect:/newAktor/" + proyek.getId();
    }

    @PostMapping("/editproyek")
    public String editProyek(@ModelAttribute("proyek")Proyek proyek) {
        proyekService.edit(proyek);
        return "redirect:/newAktor/" + proyek.getId();
    }

    @GetMapping("/newProyek")
    public String newProyekForm(Model model) {
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        Proyek proyek = new Proyek();
        model.addAttribute("proyek", proyek);
        return "new_proyek";
    }

    @GetMapping("/editProyek/{id}")
    public String editProyek(@PathVariable (value = "id") String id, Model model) {
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        Proyek proyek = proyekService.findById(id);
        model.addAttribute("proyek", proyek);
        return "edit_proyek";
    }

    @GetMapping("/newAktor/{id}")
    public String newAktorForm(@PathVariable( value = "id") String id, Model model){
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        Proyek proyek = proyekService.findById(id);

        List<Aktor> aktors = aktorService.findAllByProyekId(proyek.getId());
        model.addAttribute("aktors", aktors);
        model.addAttribute("proyek", proyek);
        return "new_aktor";
    }

    @GetMapping("/newtcf/{id}")
    public String newTcf(@PathVariable(value = "id") String id, Model model){
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        List<TCF> tcfs = tcfService.findAllByProyekId(id);
        List<TCFEnum> tcfEnum = new ArrayList<>(EnumSet.allOf(TCFEnum.class));
        List<TCFModel> tcfModels = new ArrayList<>();

        for (TCFEnum e : tcfEnum) {
            for (TCF tcf : tcfs){
                if (tcf.getCode().equals(e.name())){
                    tcfModels.add(new TCFModel(e, tcf));
                }
            }
        }

        model.addAttribute("tcfs", tcfModels);
        model.addAttribute("proyek", id);
        return "tcf_form";
    }

    @GetMapping("/fuzzyUsecase")
    public String fuzzyUseCase(Model model){
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        return "fuzzy_usecase";
    }

    @GetMapping("/home")
    public String home(Model model){
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        return "home";
    }

    @GetMapping("")
    public String login(Model model) {
        Login loginRequest = new Login();
        model.addAttribute("loginRequest", loginRequest);
        userLogin.setLogin(false);
        return "login_page";
    }

    @GetMapping("/newef/{id}")
    public String newef(@PathVariable(value = "id") String id, Model model){
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        List<EF> efs = efService.findAllByProyekId(id);
        List<EFEnum> efEnum = new ArrayList<>(EnumSet.allOf(EFEnum.class));
        List<TCFModel> efModels = new ArrayList<>();

        for (EFEnum e : efEnum) {
            for (EF ef : efs){
                if (ef.getCode().equals(e.name())){
                    efModels.add(new TCFModel(e, ef));
                }
            }
        }

        model.addAttribute("efs", efModels);
        return "ef_form";
    }

    @GetMapping("/newUsecase/{id}")
    public String newUsecaseForm(@PathVariable( value = "id") String id, Model model){
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        Proyek proyek = proyekService.findById(id);

        List<UseCase> useCases = useCaseService.findAllByProyekId(proyek.getId());
        model.addAttribute("usecases", useCases);
        model.addAttribute("proyek", proyek);
        return "new_usecase";
    }

    @GetMapping("/addAktorForm/{id}")
    public String addAktor(@PathVariable(value = "id") String id, Model model){
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        Proyek proyek = proyekService.findById(id);
        List<String> kategoris = Arrays.asList("simple", "complex", "average");

        Aktor aktor = new Aktor();
        aktor.setProyek(proyek);

        model.addAttribute("aktor", aktor);
        model.addAttribute("kategoris", kategoris);

        return "aktor_form";
    }

    @GetMapping("/addUsecaseForm/{id}")
    public String addUsecase(@PathVariable(value = "id") String id, Model model){
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        Proyek proyek = proyekService.findById(id);

        UseCase useCase = new UseCase();
        useCase.setProyek(proyek);

        model.addAttribute("usecase", useCase);

        return "usecase_form";
    }

    @GetMapping("/tcfform/{id}")
    public String tcfForm(@PathVariable(value = "id") String id, Model model){
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        TCF tcf = tcfService.findById(id);

        List<Integer> values = Arrays.asList(1,2,3,4,5);

        model.addAttribute("tcf", tcf);
        model.addAttribute("valueList", values);

        return "new_tcf";
    }

    @GetMapping("/efform/{id}")
    public String efForm(@PathVariable(value = "id") String id, Model model){
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        EF ef = efService.findById(id);

        List<Integer> values = Arrays.asList(1,2,3,4,5);

        model.addAttribute("ef", ef);
        model.addAttribute("valueList", values);

        return "new_ef";
    }

    @GetMapping("/aktorForm/{id}")
    public String aktorForm(@PathVariable(value = "id") String id, Model model){
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        Aktor aktor = aktorService.findById(id);

        List<String> kategoris = Arrays.asList("simple", "complex", "average");
        model.addAttribute("aktor", aktor);
        model.addAttribute("kategoris", kategoris);

        return "aktor_form";
    }

    @GetMapping("/usecaseForm/{id}")
    public String usecaseForm(@PathVariable(value = "id") String id, Model model){
        if (!userLogin.getLogin()){
            userLogin.setMessageLog("LOG IN TO ACCESS!!");
            Login loginRequest = new Login();
            model.addAttribute("loginRequest", loginRequest);
            userLogin.setLogin(false);
            return "login_page";
        }
        UseCase useCase = useCaseService.findById(id);

        model.addAttribute("usecase", useCase);

        return "usecase_form";
    }

    @PostMapping("/saveaktor")
    public String saveAktor(@ModelAttribute Aktor aktor) {
        String id = aktor.getProyek().getId();

        aktorService.save(aktor);

        Proyek proyek = aktor.getProyek();

        List<Aktor> aktors = aktorService.findAllByProyekId(proyek.getId());

        proyek.setJumlahAktor(aktors.size());
        proyekService.changeAmount(proyek);

        return "redirect:/newAktor/" + id;
    }

    @PostMapping("/login")
    public String logging(@ModelAttribute Login loginRequest){
        if (loginRequest.getUsername().equals(userLogin.getUsername()) && loginRequest.getPassword().equals(userLogin.getPassword())){
            userLogin.setLogin(true);
            return "redirect:/home";
        }

        return "redirect:/";
    }

    @PostMapping("/saveusecase")
    public String saveusecase(@ModelAttribute UseCase useCase) {
        String id = useCase.getProyek().getId();

        useCaseService.save(useCase);

        Proyek proyek = useCase.getProyek();

        List<UseCase> useCases = useCaseService.findAllByProyekId(proyek.getId());

        proyek.setJumlahAktor(useCases.size());
        proyekService.changeAmount(proyek);

        return "redirect:/newUsecase/" + id;
    }

    @PostMapping("/savetcf")
    public String savetcf(@ModelAttribute TCF tcf){
        String id = tcf.getProyek().getId();

        tcfService.saveValue(tcf);

        return "redirect:/newtcf/" + id;
    }

    @PostMapping("/saveef")
    public String saveef(@ModelAttribute EF ef){
        String id = ef.getProyek().getId();

        efService.saveValue(ef);

        return "redirect:/newef/" + id;
    }

}

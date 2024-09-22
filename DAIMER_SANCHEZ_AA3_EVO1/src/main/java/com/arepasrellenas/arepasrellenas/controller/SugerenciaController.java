package com.arepasrellenas.arepasrellenas.controller;

@Controller
@RequestMapping("/sugerencias")
public class SugerenciaController {

    @Autowired
    private SugerenciaService sugerenciaService;

    @GetMapping("/nueva")
    public String showNuevaSugerenciaForm(Model model) {
        model.addAttribute("sugerencia", new Sugerencia());
        return "nueva_sugerencia";
    }

    @PostMapping("/nueva")
    public String enviarSugerencia(@ModelAttribute("sugerencia") Sugerencia sugerencia) {
        sugerenciaService.saveSugerencia(sugerencia);
        return "redirect:/";
    }
}

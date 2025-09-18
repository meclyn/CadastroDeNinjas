package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // LISTAR TODOS
    @GetMapping("/listar")
    public String listarNinjas(Model model){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";
    }

    // FORMULÁRIO DE CRIAÇÃO
    @GetMapping("/adicionar")
    public String mostrarFormularioCriacao(Model model, NinjaDTO ninjaDTO){
        NinjaDTO ninja = ninjaService.criarNinja(ninjaDTO);
        model.addAttribute("ninja", ninja);
        return "formNinja";
    }

    // SALVAR NOVO
    @PostMapping("/salvar")
    public String criarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja criado com sucesso!");
        return "redirect:/ninjas/ui/listar";
    }


    // FORMULÁRIO DE EDIÇÃO
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes){
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "formNinja";
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Ninja não encontrado");
            return "redirect:/ninjas/ui/listar";
        }
    }

    // ATUALIZAR EXISTENTE
    @PostMapping("/atualizar/{id}")
    public String atualizarNinja(@PathVariable Long id, @ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes){
        NinjaDTO atualizado = ninjaService.atualizarNinja(id, ninja);
        if (atualizado != null){
            redirectAttributes.addFlashAttribute("mensagem", "Ninja atualizado com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Erro ao atualizar ninja.");
        }
        return "redirect:/ninjas/ui/listar";
    }

    // DETALHES DE UM NINJA
    @GetMapping("/detalhes/{id}")
    public String detalhesNinja(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes){
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "detalhesninja";
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Ninja não encontrado");
            return "redirect:/ninjas/ui/listar";
        }
    }

    // DELETAR
    @GetMapping("/deletar/{id}")
    public String deletarPorId(@PathVariable Long id, RedirectAttributes redirectAttributes){
        ninjaService.deletarPorId(id);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja deletado com sucesso!");
        return "redirect:/ninjas/ui/listar";
    }
}

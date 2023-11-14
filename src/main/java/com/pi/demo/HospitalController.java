/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pi.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kevin
 */
@Controller
public class HospitalController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "cadastro";
    }
    
    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }
    
       @RequestMapping("/listagem")
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteRepository.findAll();
        model.addAttribute("pacientes", pacientes);
        return "listagem";
    }
    
    @GetMapping("/atualizar/{id}")
    public String mostrarFormAtualizar(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        model.addAttribute("paciente", paciente);
        return "cadastro";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluirPaciente(@PathVariable Long id) {
        pacienteRepository.deleteById(id);
        return "redirect:/listagem";
    }
    
     @PostMapping("/salvar")
    public String salvarPaciente(@ModelAttribute Paciente paciente) {
        pacienteRepository.save(paciente);
        return "redirect:/listagem";
    }
    
}




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pi.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kevin
 */
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}


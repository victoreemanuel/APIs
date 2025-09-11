package com.example.usuario.controller;

import com.example.usuario.model.UsuarioModel;
import com.example.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioModel> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public UsuarioModel criarUsuario(@RequestBody UsuarioModel usuarioModel){
        return usuarioService.salvaUsuario(usuarioModel);
    }

    @PutMapping
    public UsuarioModel atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioModel){
        return usuarioService.atualizarUsuario(id, usuarioModel);
    }

    @DeleteMapping
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }
}

package com.duoc.auth.service;

import com.duoc.auth.model.User;
import com.duoc.auth.dto.UserDTO;
import com.duoc.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public boolean login(String email, String password) {
        return userRepository.findByEmail(email)
            .map(u -> u.getPassword().equals(password))
            .orElse(false);
    }

    public String registrar(UserDTO dto) {
        User user = new User();
        user.setRut(dto.rut);
        user.setNombre(dto.nombre);
        user.setApellido(dto.apellido);
        user.setEmail(dto.email);
        user.setPassword(dto.password);
        user.setFechaNacimiento(dto.fechaNacimiento);
        user.setDireccion(dto.direccion);
        user.setRegion(dto.region);
        user.setComuna(dto.comuna);
        
        userRepository.save(user);
        return "Usuario " + dto.nombre + " registrado con éxito en el sistema GreenBite.";
    }
}
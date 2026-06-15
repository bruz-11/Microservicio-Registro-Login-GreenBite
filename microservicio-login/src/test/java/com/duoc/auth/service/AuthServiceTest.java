package com.duoc.auth.service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.duoc.auth.dto.UserDTO;
import com.duoc.auth.model.User;
import com.duoc.auth.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthService authService;

    private UserDTO userDto;

    @BeforeEach
    void setUp() {
        userDto = new UserDTO();
        userDto.nombre = "Benjamin";
        userDto.email = "benja@duocuc.cl";
        userDto.password = "123456";
    }

    @Test
    void cuandoRegistra_entoncesRetornaExito() {
        String resultado = authService.registrar(userDto);
        verify(userRepository, times(1)).save(any(User.class));
        assertTrue(resultado.contains("registrado con éxito"));
    }

    @Test
    void cuandoLoginCorrecto_retornaTrue() {
        User user = new User();
        user.setEmail("benja@duocuc.cl");
        user.setPassword("123456");

        when(userRepository.findByEmail("benja@duocuc.cl")).thenReturn(Optional.of(user));

        boolean resultado = authService.login("benja@duocuc.cl", "123456");

        assertTrue(resultado);
    }
}
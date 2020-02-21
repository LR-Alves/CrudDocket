package br.com.docket.teste.cartorio.controller;


import br.com.docket.teste.cartorio.model.Cartorio;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.AssertTrue;

import java.util.List;

import static org.mockito.Mockito.when;


public class CartorioControllerTest {


    @Mock
    private CartorioController  cartorioController;


    @Test
    public void findall(){
        Assert.assertTrue(String.valueOf(cartorioController.findAll()), true);


    }
    @Test
    public void findById(){}

    @Test
    public void create(){}

    @Test
    public void update(){}

    @Test
    public void delete(){}


}

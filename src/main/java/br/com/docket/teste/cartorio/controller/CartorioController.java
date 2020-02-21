package br.com.docket.teste.cartorio.controller;

import br.com.docket.teste.cartorio.model.Cartorio;
import br.com.docket.teste.cartorio.repository.CartorioRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@ApiOperation("api")
@RestController
@RequestMapping("/api/v1/cartorios")
public class CartorioController {

    @Autowired
    private CartorioRepository cartorio;

    CartorioController(CartorioRepository cartorioRepository) {
        this.cartorio = cartorioRepository;
    }

    @GetMapping("/findall")
    public List findAll() {
        return cartorio.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id) {
        return cartorio.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/create")
    public Cartorio create(@Valid Cartorio carto) {
        return cartorio.save(carto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cartorio> update(@RequestBody  Cartorio carto , @PathVariable long id) {
        return cartorio.findById(id)
                .map(record -> {
                    record.setNome(carto.getNome());
                    Cartorio updated = cartorio.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());



    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return cartorio.findById(id)
                .map(record -> {
                    cartorio.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
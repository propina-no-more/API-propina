package br.propina.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping(produces = "application/json; charset=UTF-8")
    public @ResponseBody String index() {
        return "Bem-vindo ao web-server propina no more ";
    }
}

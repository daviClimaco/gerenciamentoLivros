package daviClimaco.gerenciamentoLivros.controller;

import daviClimaco.gerenciamentoLivros.entity.Livro;
import daviClimaco.gerenciamentoLivros.services.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livro")
public class LivroController {
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public void salvar(@RequestBody Livro livro){ //requestbody recebe o json e transforma em objeto
        livroService.salvar(livro);
    }

    @DeleteMapping ("{id}")
    public void deletar(@PathVariable Long id) {
        livroService.deletar(id);
    }

    @GetMapping
    public List<Livro> buscarTodos(){
        return livroService.buscarTodos(); //reotrna a lista de objetos java
    }

    @GetMapping("{id}")
    public Livro buscarPorId(@PathVariable Long id){
        return livroService.buscarLivroPorId(id); //retorna o objeto pelo id
    }

}

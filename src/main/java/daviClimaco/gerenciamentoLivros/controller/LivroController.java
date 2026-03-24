package daviClimaco.gerenciamentoLivros.controller;

import daviClimaco.gerenciamentoLivros.entity.Livro;
import daviClimaco.gerenciamentoLivros.services.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("livro")
public class LivroController {
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<Livro> salvar(@RequestBody Livro livro){ //requestbody recebe o json e transforma em objeto
        Livro requeste = livroService.salvar(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(livro.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Livro>> buscarTodos(){
        List<Livro> requeste = livroService.buscarTodos(); //reotrna a lista de objetos java
        return ResponseEntity.ok().body(requeste);
    }

    @GetMapping("{id}")
    public Livro buscarPorId(@PathVariable Long id){
        return livroService.buscarLivroPorId(id); //retorna o objeto pelo id
    }

    @PutMapping("{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livro){
        return livroService.atualizar(id, livro);
    }

}
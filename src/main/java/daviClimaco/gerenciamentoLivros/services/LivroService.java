package daviClimaco.gerenciamentoLivros.services;

import daviClimaco.gerenciamentoLivros.entity.Livro;
import daviClimaco.gerenciamentoLivros.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }

    public Livro buscarLivroPorId(Long id){
        return livroRepository.findById(id).orElse(null);
    }

    public List<Livro> buscarTodos(){
        return livroRepository.findAll();
    }

    public Livro atualizar(Long id, Livro livro){
        livro.setId(id);
        return livroRepository.save(livro);
    }

}
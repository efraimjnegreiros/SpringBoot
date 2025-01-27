package br.ifpe.jaboatao.zacademicoweb.spring_boot;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import br.ifpe.jaboatao.zacademicoweb.model.Aluno;
import br.ifpe.jaboatao.zacademicoweb.model.dao.AlunoDAO;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

// Forma oara dizer que é um controller
@Controller
public class AlunoController {
    private final AlunoDAO alunoDAO;
    
    public AlunoController(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    // @RequestMapping(value = "/cadAluno", method=RequestMethod.GET)

    @GetMapping("/cadAluno")
    public String abreFormulario(Model model) {
        model.addAttribute("aluno", new Aluno("", "", 0, "", "", "", ""));
        return "cadAluno";
    }
        
    // @RequestMapping(value = "/cadaluno", method = RequestMethod.POST)
    @PostMapping("/cadaluno")
                            //   Request (oq vem da view)  Resposta (para a view)
    public String insereAluno(@ModelAttribute Aluno aluno, Model model) {
        alunoDAO.create(aluno);

        model.addAttribute("aluno",aluno);
        model.addAttribute("mensagem", "Aluno Cadastrado com sucesso");

        return "resultInsertAluno";
    }
    @GetMapping("/listarAlunos")
    public String listarAlunos(Model model) {
        List<Aluno> alunos = alunoDAO.listAll();
        model.addAttribute("alunos", alunos);
        return "listarAlunos";
    }   

    
    
    
}

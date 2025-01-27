package br.ifpe.jaboatao.zacademicoweb.model.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import br.ifpe.jaboatao.zacademicoweb.model.Aluno;

@Repository
public class AlunoDAO {
    private final JdbcTemplate jdbcTemplate;

    public AlunoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int create(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, cpf, idade, email_pessoal, senha, matricula) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, aluno.getNome(), aluno.getCpf(), aluno.getIdade(), aluno.getEmailPessoal(), aluno.getSenha(), aluno.getMatricula());
    }

    public List<Aluno> listAll() {
        String sql = "SELECT * FROM aluno";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Aluno(
            rs.getString("nome"),
            rs.getString("cpf"),
            rs.getInt("idade"),
            rs.getString("email_pessoal"),
            rs.getString("email_institucional"), // Incluído aqui
            rs.getString("senha"),
            rs.getString("matricula")
        ));
    }
    
}

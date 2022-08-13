package br.com.challenge.apirest.alura.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.challenge.apirest.alura.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer> {

	@Query("SELECT r FROM Receita r WHERE r.descricao = :descricao AND MONTH(r.data) = :mes")
	Receita findByDescricaoAndMes(String descricao, int mes);

	@Query("SELECT r FROM Receita r WHERE r.descricao LIKE LOWER(CONCAT ('%',:descricao,'%'))")
	List<Receita> findByDescricao(String descricao); // LOWER - converte para minúsculo
}

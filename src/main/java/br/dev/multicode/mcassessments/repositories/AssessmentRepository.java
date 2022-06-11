package br.dev.multicode.mcassessments.repositories;

import br.dev.multicode.mcassessments.entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, String> {
}

package br.dev.multicode.mcassessments.repositories;

import br.dev.multicode.mcassessments.entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, String> {

  Set<Assessment> findAssessmentByUserId(String userId);

  Set<Assessment> findAssessmentByProductId(String productId);

}

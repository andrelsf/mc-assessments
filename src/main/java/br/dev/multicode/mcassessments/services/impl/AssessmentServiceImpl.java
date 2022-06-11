package br.dev.multicode.mcassessments.services.impl;

import br.dev.multicode.mcassessments.api.http.requests.AssessmentRequest;
import br.dev.multicode.mcassessments.api.http.responses.AssessmentResponse;
import br.dev.multicode.mcassessments.entities.Assessment;
import br.dev.multicode.mcassessments.repositories.AssessmentRepository;
import br.dev.multicode.mcassessments.services.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {

  private final AssessmentRepository repository;

  @Override
  @Transactional(readOnly = true)
  public Set<AssessmentResponse> getByUserId(UUID userId) {
    return repository.findAssessmentByUserId(userId.toString())
      .stream()
      .map(Assessment::toResponse)
      .collect(Collectors.toSet());
  }

  @Override
  @Transactional(readOnly = true)
  public Set<AssessmentResponse> getByProductId(UUID productId) {
    return repository.findAssessmentByProductId(productId.toString())
      .stream()
      .map(Assessment::toResponse)
      .collect(Collectors.toSet());
  }

  @Override
  @Transactional
  public void create(AssessmentRequest postAssessmentRequest) {
    repository.save(Assessment.of(postAssessmentRequest));
  }
}

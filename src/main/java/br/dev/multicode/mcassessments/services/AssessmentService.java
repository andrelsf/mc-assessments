package br.dev.multicode.mcassessments.services;

import br.dev.multicode.mcassessments.api.http.requests.AssessmentRequest;
import br.dev.multicode.mcassessments.api.http.responses.AssessmentResponse;

import java.util.Set;
import java.util.UUID;

public interface AssessmentService {

  Set<AssessmentResponse> getByUserId(UUID userId);

  Set<AssessmentResponse> getByProductId(UUID productId);

  void create(AssessmentRequest postAssessmentRequest);

}

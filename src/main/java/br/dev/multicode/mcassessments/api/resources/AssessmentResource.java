package br.dev.multicode.mcassessments.api.resources;

import br.dev.multicode.mcassessments.api.http.requests.AssessmentRequest;
import br.dev.multicode.mcassessments.api.http.responses.AssessmentResponse;
import br.dev.multicode.mcassessments.services.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(value = "/assessments",
  consumes = MediaType.APPLICATION_JSON_VALUE,
  produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AssessmentResource {

  private final AssessmentService assessmentService;

  @PostMapping
  public ResponseEntity<Void> postAssessment(@RequestBody @Valid AssessmentRequest postAssessmentRequest)
  {
    assessmentService.create(postAssessmentRequest);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/users/{userId}")
  public ResponseEntity<Set<AssessmentResponse>> getByUserId(@PathVariable UUID userId)
  {
    return ResponseEntity.ok(assessmentService.getByUserId(userId));
  }

  @GetMapping("/products/{productId}")
  public ResponseEntity<Set<AssessmentResponse>> getByProductId(@PathVariable UUID productId)
  {
    return ResponseEntity.ok(assessmentService.getByProductId(productId));
  }
}

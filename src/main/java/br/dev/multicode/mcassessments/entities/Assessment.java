package br.dev.multicode.mcassessments.entities;

import br.dev.multicode.mcassessments.api.http.requests.AssessmentRequest;
import br.dev.multicode.mcassessments.api.http.responses.AssessmentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "assessments")
public class Assessment {

  @Id
  @Column(length = 37, nullable = false)
  private String productId;

  @Column(length = 37, nullable = false)
  private String userId;

  @Column(nullable = false)
  private Integer assessment;

  @Column(nullable = false)
  private String description;

  @CreationTimestamp
  private ZonedDateTime createdAt;

  @UpdateTimestamp
  private ZonedDateTime updatedAt;

  public static Assessment of(final AssessmentRequest postAssessmentRequest) {
    return Assessment.builder()
      .productId(postAssessmentRequest.getProductId().toString())
      .userId(postAssessmentRequest.getUserId().toString())
      .assessment(postAssessmentRequest.getAssessment())
      .description(postAssessmentRequest.getDescription())
      .build();
  }

  public AssessmentResponse toResponse() {
    return AssessmentResponse.builder()
      .productId(productId)
      .userId(userId)
      .assessment(assessment)
      .description(description)
      .build();
  }
}

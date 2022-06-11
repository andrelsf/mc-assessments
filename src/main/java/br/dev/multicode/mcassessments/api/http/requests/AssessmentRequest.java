package br.dev.multicode.mcassessments.api.http.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentRequest {

  @NotNull
  private UUID productId;

  @NotNull
  private UUID userId;

  @Min(0)
  @Max(5)
  @PositiveOrZero
  private Integer assessment;

  @NotBlank
  private String description;

}

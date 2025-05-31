package com.limeus.expenseservice.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CreateExpenseRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.13.0")
public class CreateExpenseRequest {

  private BigDecimal amount;

  private String category;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime date;

  private @Nullable String comment;

  private @Nullable UUID familyId;

  public CreateExpenseRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateExpenseRequest(BigDecimal amount, String category, OffsetDateTime date) {
    this.amount = amount;
    this.category = category;
    this.date = date;
  }

  public CreateExpenseRequest amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The amount of the expense.
   * @return amount
   */
  @NotNull @Valid 
  @Schema(name = "amount", example = "50.0", description = "The amount of the expense.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("amount")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public CreateExpenseRequest category(String category) {
    this.category = category;
    return this;
  }

  /**
   * The category of the expense.
   * @return category
   */
  @NotNull 
  @Schema(name = "category", example = "Travel", description = "The category of the expense.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public CreateExpenseRequest date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Date and time of the expense.
   * @return date
   */
  @NotNull @Valid 
  @Schema(name = "date", example = "2023-10-27T14:30:00+03:00", description = "Date and time of the expense.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("date")
  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public CreateExpenseRequest comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Optional comment about the expense.
   * @return comment
   */
  
  @Schema(name = "comment", example = "Bought groceries for the week.", description = "Optional comment about the expense.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("comment")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public CreateExpenseRequest familyId(UUID familyId) {
    this.familyId = familyId;
    return this;
  }

  /**
   * Unique identifier of the family to which the expense belongs. Null if not associated with a family.
   * @return familyId
   */
  @Valid 
  @Schema(name = "familyId", example = "01234567-89ab-cdef-0123-456789abcdef", description = "Unique identifier of the family to which the expense belongs. Null if not associated with a family.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("familyId")
  public UUID getFamilyId() {
    return familyId;
  }

  public void setFamilyId(UUID familyId) {
    this.familyId = familyId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateExpenseRequest createExpenseRequest = (CreateExpenseRequest) o;
    return Objects.equals(this.amount, createExpenseRequest.amount) &&
        Objects.equals(this.category, createExpenseRequest.category) &&
        Objects.equals(this.date, createExpenseRequest.date) &&
        Objects.equals(this.comment, createExpenseRequest.comment) &&
        Objects.equals(this.familyId, createExpenseRequest.familyId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, category, date, comment, familyId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateExpenseRequest {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    familyId: ").append(toIndentedString(familyId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


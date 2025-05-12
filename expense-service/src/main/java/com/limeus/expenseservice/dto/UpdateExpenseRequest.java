package com.limeus.expenseservice.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UpdateExpenseRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.13.0")
public class UpdateExpenseRequest {

  private @Nullable BigDecimal amount;

  private @Nullable String category;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime date;

  private @Nullable String comment;

  public UpdateExpenseRequest amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The updated amount of the expense.
   * @return amount
   */
  @Valid 
  @Schema(name = "amount", example = "60.0", description = "The updated amount of the expense.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amount")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public UpdateExpenseRequest category(String category) {
    this.category = category;
    return this;
  }

  /**
   * The updated category of the expense.
   * @return category
   */
  
  @Schema(name = "category", example = "Entertainment", description = "The updated category of the expense.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public UpdateExpenseRequest date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * The updated date and time of the expense.
   * @return date
   */
  @Valid 
  @Schema(name = "date", example = "2023-10-27T14:30:00+03:00", description = "The updated date and time of the expense.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public UpdateExpenseRequest comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Updated comment about the expense.
   * @return comment
   */
  
  @Schema(name = "comment", example = "Went to the movies.", description = "Updated comment about the expense.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("comment")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateExpenseRequest updateExpenseRequest = (UpdateExpenseRequest) o;
    return Objects.equals(this.amount, updateExpenseRequest.amount) &&
        Objects.equals(this.category, updateExpenseRequest.category) &&
        Objects.equals(this.date, updateExpenseRequest.date) &&
        Objects.equals(this.comment, updateExpenseRequest.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, category, date, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateExpenseRequest {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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


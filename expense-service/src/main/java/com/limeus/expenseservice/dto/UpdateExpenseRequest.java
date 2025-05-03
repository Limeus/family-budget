package com.limeus.expenseservice.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * UpdateExpenseRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.13.0")
public class UpdateExpenseRequest {

  private @Nullable Float amount;

  private @Nullable String category;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate date;

  private @Nullable String comment;

  public UpdateExpenseRequest amount(Float amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The updated amount of the expense.
   * @return amount
   */
  
  @Schema(name = "amount", example = "60.0", description = "The updated amount of the expense.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amount")
  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
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

  public UpdateExpenseRequest date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * The updated date of the expense.
   * @return date
   */
  @Valid 
  @Schema(name = "date", example = "2023-10-28", description = "The updated date of the expense.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
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


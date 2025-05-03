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
 * CreateExpenseRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.13.0")
public class CreateExpenseRequest {

  private @Nullable Float amount;

  private @Nullable String category;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate date;

  private @Nullable String comment;

  public CreateExpenseRequest amount(Float amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The amount of the expense.
   * @return amount
   */
  
  @Schema(name = "amount", example = "50.0", description = "The amount of the expense.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amount")
  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
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
  
  @Schema(name = "category", example = "Travel", description = "The category of the expense.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public CreateExpenseRequest date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * The date of the expense.
   * @return date
   */
  @Valid 
  @Schema(name = "date", example = "2023-10-27", description = "The date of the expense.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
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
        Objects.equals(this.comment, createExpenseRequest.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, category, date, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateExpenseRequest {\n");
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


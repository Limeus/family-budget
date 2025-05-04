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
 * CreateExpenseRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.13.0")
public class CreateExpenseRequest {

  private BigDecimal amount;

  private String category;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime date;

  private @Nullable String comment;

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


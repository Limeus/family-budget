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
 * ExpenseResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.13.0")
public class ExpenseResponse {

  private UUID id;

  private BigDecimal amount;

  private String category;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime date;

  private @Nullable String comment;

  private UUID userId;

  private UUID familyId;

  public ExpenseResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ExpenseResponse(UUID id, BigDecimal amount, String category, OffsetDateTime date, UUID userId, UUID familyId) {
    this.id = id;
    this.amount = amount;
    this.category = category;
    this.date = date;
    this.userId = userId;
    this.familyId = familyId;
  }

  public ExpenseResponse id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the expense.
   * @return id
   */
  @NotNull @Valid 
  @Schema(name = "id", example = "a1b2c3d4-e5f6-7890-1234-567890abcdef", description = "Unique identifier of the expense.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ExpenseResponse amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The exact amount of the expense. Java uses BigDecimal
   * @return amount
   */
  @NotNull @Valid 
  @Schema(name = "amount", example = "1234.56", description = "The exact amount of the expense. Java uses BigDecimal", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("amount")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public ExpenseResponse category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Category of the expense (e.g., Groceries, Entertainment, Travel).
   * @return category
   */
  @NotNull 
  @Schema(name = "category", example = "Travel", description = "Category of the expense (e.g., Groceries, Entertainment, Travel).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public ExpenseResponse date(OffsetDateTime date) {
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

  public ExpenseResponse comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Optional comment or note about the expense.
   * @return comment
   */
  
  @Schema(name = "comment", example = "Bought groceries at the local supermarket.", description = "Optional comment or note about the expense.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("comment")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public ExpenseResponse userId(UUID userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Unique identifier of the user who created the expense.
   * @return userId
   */
  @NotNull @Valid 
  @Schema(name = "userId", example = "fedcba98-7654-3210-fedc-ba9876543210", description = "Unique identifier of the user who created the expense.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userId")
  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public ExpenseResponse familyId(UUID familyId) {
    this.familyId = familyId;
    return this;
  }

  /**
   * Unique identifier of the family to which the expense belongs. Null if not associated with a family.
   * @return familyId
   */
  @NotNull @Valid 
  @Schema(name = "familyId", example = "01234567-89ab-cdef-0123-456789abcdef", description = "Unique identifier of the family to which the expense belongs. Null if not associated with a family.", requiredMode = Schema.RequiredMode.REQUIRED)
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
    ExpenseResponse expenseResponse = (ExpenseResponse) o;
    return Objects.equals(this.id, expenseResponse.id) &&
        Objects.equals(this.amount, expenseResponse.amount) &&
        Objects.equals(this.category, expenseResponse.category) &&
        Objects.equals(this.date, expenseResponse.date) &&
        Objects.equals(this.comment, expenseResponse.comment) &&
        Objects.equals(this.userId, expenseResponse.userId) &&
        Objects.equals(this.familyId, expenseResponse.familyId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, amount, category, date, comment, userId, familyId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExpenseResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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


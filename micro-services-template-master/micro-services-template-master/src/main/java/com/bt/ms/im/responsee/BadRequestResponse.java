package com.bt.ms.im.responsee;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BadRequestResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-15T09:55:47.540785400+05:30[Asia/Calcutta]")


public class BadRequestResponse   {
  @JsonProperty("error_code")
  private Integer errorCode = null;

  @JsonProperty("error_message")
  private String errorMessage = null;

  public BadRequestResponse errorCode(Integer errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * Error code for bad request
   * @return errorCode
   **/
  @Schema(description = "Error code for bad request")
  
    public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  public BadRequestResponse errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * Description of the bad request error
   * @return errorMessage
   **/
  @Schema(example = "Missing header", description = "Description of the bad request error")
  
    public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BadRequestResponse badRequestResponse = (BadRequestResponse) o;
    return Objects.equals(this.errorCode, badRequestResponse.errorCode) &&
        Objects.equals(this.errorMessage, badRequestResponse.errorMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCode, errorMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BadRequestResponse {\n");
    
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

package com.bt.ms.im.response;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SuccessResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-15T09:55:47.540785400+05:30[Asia/Calcutta]")


public class SuccessResponse   {
  @JsonProperty("status")
  private String status = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("data")
  private WifiSessionParameters data = null;

  public SuccessResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * OK for success
   * @return status
   **/
  @Schema(description = "OK for success")
  
    public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public SuccessResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Success message
   * @return message
   **/
  @Schema(description = "Success message")
  
    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public SuccessResponse data(WifiSessionParameters data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
   **/
  @Schema(description = "")
  
    @Valid
    public WifiSessionParameters getData() {
    return data;
  }

  public void setData(WifiSessionParameters data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponse successResponse = (SuccessResponse) o;
    return Objects.equals(this.status, successResponse.status) &&
        Objects.equals(this.message, successResponse.message) &&
        Objects.equals(this.data, successResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, message, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponse {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

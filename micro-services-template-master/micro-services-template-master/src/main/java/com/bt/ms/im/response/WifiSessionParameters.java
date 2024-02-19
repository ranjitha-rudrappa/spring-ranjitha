package com.bt.ms.im.response;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * WifiSessionParameters
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-15T09:55:47.540785400+05:30[Asia/Calcutta]")


public class WifiSessionParameters   {
  @JsonProperty("cfsid")
  private String cfsid = null;

  @JsonProperty("uuid")
  private String uuid = null;

  public WifiSessionParameters cfsid(String cfsid) {
    this.cfsid = cfsid;
    return this;
  }

  /**
   * Content filtering id - GUID
   * @return cfsid
   **/
  @Schema(example = "abcd-1234-efgh-5678", description = "Content filtering id - GUID")
  
    public String getCfsid() {
    return cfsid;
  }

  public void setCfsid(String cfsid) {
    this.cfsid = cfsid;
  }

  public WifiSessionParameters uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

  /**
   * WiFi service instance GUID - for unique user statistics
   * @return uuid
   **/
  @Schema(example = "9876-zyxw-4321-vuts", required = true, description = "WiFi service instance GUID - for unique user statistics")
      @NotNull

    public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WifiSessionParameters wifiSessionParameters = (WifiSessionParameters) o;
    return Objects.equals(this.cfsid, wifiSessionParameters.cfsid) &&
        Objects.equals(this.uuid, wifiSessionParameters.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cfsid, uuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WifiSessionParameters {\n");
    
    sb.append("    cfsid: ").append(toIndentedString(cfsid)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

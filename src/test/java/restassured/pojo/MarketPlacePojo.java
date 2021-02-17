
package restassured.pojo;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "numberOfBids",
    "commodity",
    "vehicleType",
    "price",
    "addresses"
})
public class MarketPlacePojo {

    @JsonProperty("key")
    private String key;
    @JsonProperty("numberOfBids")
    private Integer numberOfBids;
    @JsonProperty("commodity")
    private String commodity;
    @JsonProperty("vehicleType")
    private String vehicleType;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("addresses")
    private List<Address> addresses = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("numberOfBids")
    public Integer getNumberOfBids() {
        return numberOfBids;
    }

    @JsonProperty("numberOfBids")
    public void setNumberOfBids(Integer numberOfBids) {
        this.numberOfBids = numberOfBids;
    }

    @JsonProperty("commodity")
    public String getCommodity() {
        return commodity;
    }

    @JsonProperty("commodity")
    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    @JsonProperty("vehicleType")
    public String getVehicleType() {
        return vehicleType;
    }

    @JsonProperty("vehicleType")
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("addresses")
    public List<Address> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

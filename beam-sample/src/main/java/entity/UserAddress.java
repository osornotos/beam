package entity;

public class UserAddress extends BaseEntity {
  private String city;
  private String commune;
  private String address;
  private Integer longitude;
  private Integer latitude;
  private Integer type;
  private String district;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCommune() {
    return commune;
  }

  public void setCommune(String commune) {
    this.commune = commune;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getLongitude() {
    return longitude;
  }

  public void setLongitude(Integer longitude) {
    this.longitude = longitude;
  }

  public Integer getLatitude() {
    return latitude;
  }

  public void setLatitude(Integer latitude) {
    this.latitude = latitude;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public UserAddress() {}

  @Override
  public String toString() {
    return "UserAddress{"
        + "city='"
        + city
        + '\''
        + ", commune='"
        + commune
        + '\''
        + ", address='"
        + address
        + '\''
        + ", longitude="
        + longitude
        + ", latitude="
        + latitude
        + ", type="
        + type
        + ", district='"
        + district
        + '\''
        + '}';
  }
}

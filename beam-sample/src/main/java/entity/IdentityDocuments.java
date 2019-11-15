package entity;

public class IdentityDocuments extends BaseEntity {
  private String identityNumber;
  private String identityType;
  private String issuePlace;
  private Boolean isPrimary;
  private Integer issueDate;

  public String getIdentityNumber() {
    return identityNumber;
  }

  public void setIdentityNumber(String identityNumber) {
    this.identityNumber = identityNumber;
  }

  public String getIdentityType() {
    return identityType;
  }

  public void setIdentityType(String identityType) {
    this.identityType = identityType;
  }

  public String getIssuePlace() {
    return issuePlace;
  }

  public void setIssuePlace(String issuePlace) {
    this.issuePlace = issuePlace;
  }

  public Boolean getPrimary() {
    return isPrimary;
  }

  public void setPrimary(Boolean primary) {
    isPrimary = primary;
  }

  public Integer getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(Integer issueDate) {
    this.issueDate = issueDate;
  }

  public IdentityDocuments() {}

  @Override
  public String toString() {
    return "IdentityDocuments{"
        + "identityNumber='"
        + identityNumber
        + '\''
        + ", identityType='"
        + identityType
        + '\''
        + ", issuePlace='"
        + issuePlace
        + '\''
        + ", isPrimary="
        + isPrimary
        + ", issueDate="
        + issueDate
        + '}';
  }
}

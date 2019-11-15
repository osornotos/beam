package entity;

import java.util.List;

public class UserProfilePayload extends BaseEntity {
  private Integer userId;
  private Integer createdAt;
  private Integer updatedAt;
  private String phoneNumber;
  private String secondaryPhoneNumber;
  private String csn;
  private String email;
  private String firstName;
  private String lastName;
  private String fullNameWithoutAccents;
  private String fullName;
  private Integer dob;
  private Integer gender;
  private String referralCode;
  private String referredBy;
  private Integer maritalStatus;
  private String occupation;
  private String position;
  private String nationality;
  private String nationality2;
  private Integer kycLevel;
  private String IdentityType;
  private String identityId;
  private String accountStatus;
  private String walletId;
  private String walletLevel;
  private String walletNote;
  private Integer walletCreatedDate;
  private Integer walletUpdatedDate;
  private String walletRefCode;
  private Integer walletLevelCreatedDate;
  private String walletStatus;
  private Boolean hasLinkedBank;
  private Boolean haveVnaTransaction;
  private Boolean haveVingroupTransaction;
  private String bankSourceInfo;
  private String kycSourceInfo;
  private List<UserAddress> userAddress;
  private List<IdentityDocuments> identityDocuments;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Integer createdAt) {
    this.createdAt = createdAt;
  }

  public Integer getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Integer updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getSecondaryPhoneNumber() {
    return secondaryPhoneNumber;
  }

  public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
    this.secondaryPhoneNumber = secondaryPhoneNumber;
  }

  public String getCsn() {
    return csn;
  }

  public void setCsn(String csn) {
    this.csn = csn;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFullNameWithoutAccents() {
    return fullNameWithoutAccents;
  }

  public void setFullNameWithoutAccents(String fullNameWithoutAccents) {
    this.fullNameWithoutAccents = fullNameWithoutAccents;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Integer getDob() {
    return dob;
  }

  public void setDob(Integer dob) {
    this.dob = dob;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public String getReferralCode() {
    return referralCode;
  }

  public void setReferralCode(String referralCode) {
    this.referralCode = referralCode;
  }

  public String getReferredBy() {
    return referredBy;
  }

  public void setReferredBy(String referredBy) {
    this.referredBy = referredBy;
  }

  public Integer getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(Integer maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public String getNationality2() {
    return nationality2;
  }

  public void setNationality2(String nationality2) {
    this.nationality2 = nationality2;
  }

  public Integer getKycLevel() {
    return kycLevel;
  }

  public void setKycLevel(Integer kycLevel) {
    this.kycLevel = kycLevel;
  }

  public String getIdentityType() {
    return IdentityType;
  }

  public void setIdentityType(String identityType) {
    IdentityType = identityType;
  }

  public String getIdentityId() {
    return identityId;
  }

  public void setIdentityId(String identityId) {
    this.identityId = identityId;
  }

  public String getAccountStatus() {
    return accountStatus;
  }

  public void setAccountStatus(String accountStatus) {
    this.accountStatus = accountStatus;
  }

  public String getWalletId() {
    return walletId;
  }

  public void setWalletId(String walletId) {
    this.walletId = walletId;
  }

  public String getWalletLevel() {
    return walletLevel;
  }

  public void setWalletLevel(String walletLevel) {
    this.walletLevel = walletLevel;
  }

  public String getWalletNote() {
    return walletNote;
  }

  public void setWalletNote(String walletNote) {
    this.walletNote = walletNote;
  }

  public Integer getWalletCreatedDate() {
    return walletCreatedDate;
  }

  public void setWalletCreatedDate(Integer walletCreatedDate) {
    this.walletCreatedDate = walletCreatedDate;
  }

  public Integer getWalletUpdatedDate() {
    return walletUpdatedDate;
  }

  public void setWalletUpdatedDate(Integer walletUpdatedDate) {
    this.walletUpdatedDate = walletUpdatedDate;
  }

  public String getWalletRefCode() {
    return walletRefCode;
  }

  public void setWalletRefCode(String walletRefCode) {
    this.walletRefCode = walletRefCode;
  }

  public Integer getWalletLevelCreatedDate() {
    return walletLevelCreatedDate;
  }

  public void setWalletLevelCreatedDate(Integer walletLevelCreatedDate) {
    this.walletLevelCreatedDate = walletLevelCreatedDate;
  }

  public String getWalletStatus() {
    return walletStatus;
  }

  public void setWalletStatus(String walletStatus) {
    this.walletStatus = walletStatus;
  }

  public Boolean getHasLinkedBank() {
    return hasLinkedBank;
  }

  public void setHasLinkedBank(Boolean hasLinkedBank) {
    this.hasLinkedBank = hasLinkedBank;
  }

  public Boolean getHaveVnaTransaction() {
    return haveVnaTransaction;
  }

  public void setHaveVnaTransaction(Boolean haveVnaTransaction) {
    this.haveVnaTransaction = haveVnaTransaction;
  }

  public Boolean getHaveVingroupTransaction() {
    return haveVingroupTransaction;
  }

  public void setHaveVingroupTransaction(Boolean haveVingroupTransaction) {
    this.haveVingroupTransaction = haveVingroupTransaction;
  }

  public String getBankSourceInfo() {
    return bankSourceInfo;
  }

  public void setBankSourceInfo(String bankSourceInfo) {
    this.bankSourceInfo = bankSourceInfo;
  }

  public String getKycSourceInfo() {
    return kycSourceInfo;
  }

  public void setKycSourceInfo(String kycSourceInfo) {
    this.kycSourceInfo = kycSourceInfo;
  }

  public List<UserAddress> getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(List<UserAddress> userAddress) {
    this.userAddress = userAddress;
  }

  public List<IdentityDocuments> getIdentityDocuments() {
    return identityDocuments;
  }

  public void setIdentityDocuments(List<IdentityDocuments> identityDocuments) {
    this.identityDocuments = identityDocuments;
  }

  public UserProfilePayload() {}

  @Override
  public String toString() {
    return "UserProfilePayload{"
        + "userId="
        + userId
        + ", createdAt="
        + createdAt
        + ", updatedAt="
        + updatedAt
        + ", phoneNumber='"
        + phoneNumber
        + '\''
        + ", secondaryPhoneNumber='"
        + secondaryPhoneNumber
        + '\''
        + ", csn='"
        + csn
        + '\''
        + ", email='"
        + email
        + '\''
        + ", firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", fullNameWithoutAccents='"
        + fullNameWithoutAccents
        + '\''
        + ", fullName='"
        + fullName
        + '\''
        + ", dob="
        + dob
        + ", gender="
        + gender
        + ", referralCode='"
        + referralCode
        + '\''
        + ", referredBy='"
        + referredBy
        + '\''
        + ", maritalStatus="
        + maritalStatus
        + ", occupation='"
        + occupation
        + '\''
        + ", position='"
        + position
        + '\''
        + ", nationality='"
        + nationality
        + '\''
        + ", nationality2='"
        + nationality2
        + '\''
        + ", kycLevel="
        + kycLevel
        + ", IdentityType='"
        + IdentityType
        + '\''
        + ", identityId='"
        + identityId
        + '\''
        + ", accountStatus='"
        + accountStatus
        + '\''
        + ", walletId='"
        + walletId
        + '\''
        + ", walletLevel='"
        + walletLevel
        + '\''
        + ", walletNote='"
        + walletNote
        + '\''
        + ", walletCreatedDate="
        + walletCreatedDate
        + ", walletUpdatedDate="
        + walletUpdatedDate
        + ", walletRefCode='"
        + walletRefCode
        + '\''
        + ", walletLevelCreatedDate="
        + walletLevelCreatedDate
        + ", walletStatus='"
        + walletStatus
        + '\''
        + ", hasLinkedBank="
        + hasLinkedBank
        + ", haveVnaTransaction="
        + haveVnaTransaction
        + ", haveVingroupTransaction="
        + haveVingroupTransaction
        + ", bankSourceInfo='"
        + bankSourceInfo
        + '\''
        + ", kycSourceInfo='"
        + kycSourceInfo
        + '\''
        + ", userAddress="
        + userAddress
        + ", identityDocuments="
        + identityDocuments
        + '}';
  }
}

package tpf.spring.data.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id", length = 11)
    private Integer userId;

    @Column(name = "username", length = 50)
    private String userName;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "activation_state", length = 11)
    private  Integer activationState;

    @Column(name = "activation_code", length = 50)
    private String activationCode;

    @Column(name = "join_time", length = 20)
    private Integer joinTime;

    @Column(name = "avatar_url", length = 200)
    private String avatarUrl;

    @Column(name = "gender", length = 11)
    private Integer gender;

    @Column(name = "simple_desc", length = 50)
    private String simpleDesc;

    @Column(name = "position", length = 100)
    private String position;

    @Column(name = "industry", length = 100)
    private String industry;

    @Column(name = "career", length = 100)
    private String career;

    @Column(name = "education", length = 100)
    private String education;

    @Column(name = "full_desc", length = 300)
    private String fullDesc;

    @Column(name = "liked_count", length = 11)
    private Integer likedCount;

    @Column(name = "collected_count", length = 11)
    private Integer collectedCount;

    @Column(name = "follow_count", length = 11)
    private Integer followCount;

    @Column(name = "followed_count", length = 11)
    private Integer followedCount;

    @Column(name = "scaned_count", length = 11)
    private Integer scanedCount;

    @Column(name = "weibo_user_id", length = 30)
    private String weiboUserId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getActivationState() {
        return activationState;
    }

    public void setActivationState(Integer activationState) {
        this.activationState = activationState;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Integer getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Integer joinTime) {
        this.joinTime = joinTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getSimpleDesc() {
        return simpleDesc;
    }

    public void setSimpleDesc(String simpleDesc) {
        this.simpleDesc = simpleDesc;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }

    public Integer getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(Integer likedCount) {
        this.likedCount = likedCount;
    }

    public Integer getCollectedCount() {
        return collectedCount;
    }

    public void setCollectedCount(Integer collectedCount) {
        this.collectedCount = collectedCount;
    }

    public Integer getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
    }

    public Integer getFollowedCount() {
        return followedCount;
    }

    public void setFollowedCount(Integer followedCount) {
        this.followedCount = followedCount;
    }

    public Integer getScanedCount() {
        return scanedCount;
    }

    public void setScanedCount(Integer scanedCount) {
        this.scanedCount = scanedCount;
    }

    public String getWeiboUserId() {
        return weiboUserId;
    }

    public void setWeiboUserId(String weiboUserId) {
        this.weiboUserId = weiboUserId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", activationState=" + activationState +
                ", activationCode='" + activationCode + '\'' +
                ", joinTime=" + joinTime +
                ", userName='" + userName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                ", simpleDesc='" + simpleDesc + '\'' +
                ", position='" + position + '\'' +
                ", industry='" + industry + '\'' +
                ", career='" + career + '\'' +
                ", education='" + education + '\'' +
                ", fullDesc='" + fullDesc + '\'' +
                ", likedCount=" + likedCount +
                ", collectedCount=" + collectedCount +
                ", followCount=" + followCount +
                ", followedCount=" + followedCount +
                ", scanedCount=" + scanedCount +
                ", weiboUserId='" + weiboUserId + '\'' +
                '}';
    }
}

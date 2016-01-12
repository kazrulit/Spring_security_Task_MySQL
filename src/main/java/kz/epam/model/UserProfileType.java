package kz.epam.model;

/**
 * Created by Khamid_Sarmanov on 1/8/2016.
 */
public enum UserProfileType {
    USER("USER"),
    ADMIN("ADMIN");

    String userProfileType;

    private UserProfileType(String userProfileType) {
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType() {
        return userProfileType;
    }
}

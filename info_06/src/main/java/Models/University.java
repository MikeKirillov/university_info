package Models;

import Enums.StudyProfile;
import com.google.gson.annotations.SerializedName;

public class University {
    @SerializedName("universityId")
    private String id;
    @SerializedName("universityName")
    private String fullName;
    @SerializedName("universityShortName")
    private String shortName;
    @SerializedName("foundation")
    private int yearOfFoundation;
    @SerializedName("profile")
    private StudyProfile mainProfile;

    public University() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public boolean isEmpty() {
        return (this.id == null || this.id.isBlank()) &&
                (this.fullName == null || this.fullName.isBlank()) &&
                (this.shortName == null || this.shortName.isBlank()) &&
                (this.yearOfFoundation == 0) &&
                (this.mainProfile == null || (this.mainProfile.getProfileName()).isBlank());
    }

    @Override
    public String toString() {
        return "University:" +
                " id = " + id +
                ", fullName = " + fullName +
                ", shortName = " + shortName +
                ", yearOfFoundation = " + yearOfFoundation +
                ", mainProfile = " + mainProfile;
    }
}
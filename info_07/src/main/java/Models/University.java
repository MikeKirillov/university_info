package Models;

import Enums.StudyProfile;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    @SerializedName("universityId")
    @XmlElement(name = "universityId")
    private String id;

    @SerializedName("universityName")
    @XmlElement(name = "universityName")
    private String fullName;

    @SerializedName("universityShortName")
    @XmlTransient
    private String shortName;

    @SerializedName("foundation")
    @XmlTransient
    private int yearOfFoundation;

    @SerializedName("profile")
    @XmlElement(name = "universityProfile")
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
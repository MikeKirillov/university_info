package Enums;

public enum StudyProfile {
    PHYSICS("Physics"),
    MATHEMATICS("Math"),
    MEDICINE("Medicine"),
    LINGUISTICS("Linguistic");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}

package Enums;

public enum StudyProfile {
    PHYSICS("Physics"),
    MEDICINE("Medicine"),
    LINGUISTICS("Linguistic"),
    MATHEMATICS("Math");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}

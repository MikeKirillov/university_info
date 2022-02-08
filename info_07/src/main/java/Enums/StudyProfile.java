package Enums;

public enum StudyProfile {
    PHYSICS("physics"),
    MEDICINE("medicine"),
    LINGUISTICS("linguistic"),
    MATHEMATICS("math");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}

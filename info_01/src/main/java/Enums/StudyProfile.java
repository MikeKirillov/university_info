package Enums;

public enum StudyProfile {
    ARCHITECTURE("Architecture"),
    DESIGN("Design"),
    ENGINEERING("Engineering"),
    ACCOUNTING("Accounting and finance"),
    BIOLOGY("Biology"),
    HEALTHCARE("Health and social care"),
    LAW("Law"),
    HISTORY("History"),
    MANAGEMENT("Business and management");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}

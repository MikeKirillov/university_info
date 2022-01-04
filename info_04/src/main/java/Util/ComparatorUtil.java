package Util;

import Comparator.*;
import Enums.StudentComparatorType;
import Enums.UniversityComparatorType;

public class ComparatorUtil {
    private ComparatorUtil() {
    }

    public static StudentComparator getStudentComparator(StudentComparatorType type) {
        return switch (type) {
            case AVG_EXAM_SCORE -> new StudentAvgExamScoreComparator();
            case COURSE -> new StudentCourseComparator();
            case FULL_NAME -> new StudentFullNameComparator();
            case UNIVERSITY_ID -> new StudentUniversityIdComparator();
        };
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType type) {
        return switch (type) {
            case FULL_NAME -> new UniversityFullNameComparator();
            case ID -> new UniversityIdComparator();
            case PROFILE -> new UniversityProfileComparator();
            case SHORT_NAME -> new UniversityShortNameComparator();
            case YEAR -> new UniversityYearComparator();
        };
    }
}

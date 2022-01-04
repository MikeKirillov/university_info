package Util;

import Models.Student;
import Models.University;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class JsonUtil {
    private JsonUtil() {
    }

    // Student object to JSON
    public static String studentJson(Student student) {
        return new GsonBuilder().create().toJson(student);
    }

    // JSON string to Student object
    public static Student jsonStudent(String json) {
        return new Gson().fromJson(json, Student.class);
    }

    // University object to JSON
    public static String universityJson(University university) {
        return new GsonBuilder().create().toJson(university);
    }

    // JSON string to University object
    public static University jsonUniversity(String json) {
        return new Gson().fromJson(json, University.class);
    }

    // Student objects list to JSON
    public static String studentListJson(List<Student> students) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);
    }

    // JSON to Student objects list
    public static List<Student> jsonStudentList(String json) {
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {
        }.getType());
    }

    // University objects list to JSON
    public static String universityListJson(List<University> universities) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(universities);
    }

    // JSON to University objects list
    public static List<University> jsonListUniversity(String json) {
        return new Gson().fromJson(json, new TypeToken<List<University>>() {
        }.getType());
    }
}

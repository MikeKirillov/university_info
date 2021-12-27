package io;

import Enums.StudyProfile;
import Models.Student;
import Models.University;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsFileReader {
    private XlsFileReader() {
    }

    public static List<University> readUniversity(String filePath) throws IOException {
        List<University> universities = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(filePath);
        String subStr = getSubStr(filePath);
        int universitySheetIndex = 2;

        Iterator<Row> rows = getIteratorRows(inputStream, subStr, universitySheetIndex);
        // skipping top row of column names
        rows.next();

        // possible to add manual deleting of 1st column name row

        while (rows.hasNext()) {
            Row row = rows.next();
            University university = new University();
            // filling class object with column values per file rows in a condition
            university.setId(row.getCell(0).getStringCellValue());
            university.setFullName(row.getCell(1).getStringCellValue());
            university.setShortName(row.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int) row.getCell(3).getNumericCellValue());

//            StudyProfile sp = StudyProfile.valueOf(row.getCell(4).getStringCellValue().trim().toUpperCase());
//            university.setMainProfile(sp);
            university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, row.getCell(4).getStringCellValue()));
            // adding class object into the list
            universities.add(university);
        }
        return universities;
    }

    public static List<Student> readStudent(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(filePath);
        String subStr = getSubStr(filePath);
        int studentSheetIndex = 1;

        Iterator<Row> rows = getIteratorRows(inputStream, subStr, studentSheetIndex);
        // skipping top row of column names
        rows.next();

        while (rows.hasNext()) {
            Row row = rows.next();
            Student student = new Student();
            // filling class object with column values per file rows in a condition
            student.setUniversityId(row.getCell(0).getStringCellValue());
            student.setFullName(row.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int) row.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float) row.getCell(3).getNumericCellValue());
            // adding class object into the list
            students.add(student);
        }
        return students;
    }

    private static String getSubStr(String filePath) {
        int dotIndex = filePath.lastIndexOf(".");
        String subStr = filePath.substring(dotIndex + 1);
        return subStr;
    }

    private static Iterator<Row> getIteratorRows(FileInputStream inputStream, String subStr, int sheetIndex) throws IOException {
        Iterator<Row> rows = switch (subStr) {
            case "xlsx" -> getXlsxRows(inputStream, sheetIndex);
            case "xls" -> getXlsRows(inputStream, sheetIndex);
            default -> null;
        };
        // alternate view 01
/*
        if (subStr.equals("xlsx")) {
            return getXlsxRows(inputStream, sheetIndex);
        } else if (subStr.equals("xls")) {
            return getXlsRows(inputStream, sheetIndex);
        } else return rows;
*/
        // alternate view 02
/*
        switch (subStr) {
            case "xlsx":
                rows = getXlsxRows(inputStream, sheetIndex);
                break;
            case "xls":
                rows = getXlsRows(inputStream, sheetIndex);
                break;
            default:
                rows = null;
                break;
        }
*/

        return rows;
    }

    private static Iterator<Row> getXlsxRows(FileInputStream inputStream, int sheetIndex) throws IOException {
        Iterator<Row> rows;
        XSSFWorkbook xwb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = xwb.getSheetAt(sheetIndex);
        return rows = sheet.iterator();
    }

    private static Iterator<Row> getXlsRows(FileInputStream inputStream, int sheetIndex) throws IOException {
        Iterator<Row> rows;
        HSSFWorkbook hwb = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = hwb.getSheetAt(sheetIndex);
        return rows = sheet.iterator();
    }
}
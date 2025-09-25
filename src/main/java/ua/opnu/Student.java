package ua.opnu;

public class Student {
    private String name;
    private int year;
    private String[] courses;
    private int courseCount;

    public Student(String name, int year) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ім'я не може бути порожнім");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік навчання має бути від 1 до 4");
        }

        this.name = name;
        this.year = year;
        this.courses = new String[100];
        this.courseCount = 0;
    }

    public void addCourse(String courseName) {
        if (courseName != null && !courseName.isEmpty()) {
            if (courseCount < courses.length) {
                courses[courseCount] = courseName;
                courseCount++;
            } else {
                System.out.println("Неможливо додати більше дисциплін!");
            }
        } else {
            System.out.println("Некоректна назва дисципліни!");
        }
    }

    public void dropAll() {
        for (int i = 0; i < courseCount; i++) {
            courses[i] = null;
        }
        courseCount = 0;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public String getName() {
        return name;
    }

    public int getTuition() {
        return year * 20000;
    }

    public int getYear() {
        return year;
    }
}
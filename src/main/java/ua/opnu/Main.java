package ua.opnu;

public class Main {
    public static void main(String[] args) {
        Student st = new Student("Іван", 2);

        st.addCourse("Програмування");
        st.addCourse("Математика");
        st.addCourse("Фізика");

        System.out.println(st.getName() + ": кількість вивчаємих дисциплін - " + st.getCourseCount());
        System.out.println(st.getName() + ": рік навчання - " + st.getYear());
        System.out.println(st.getName() + ": заплатив за навчання - " + st.getTuition());

        st.dropAll();
        System.out.println(st.getName() + ": кількість вивчаємих дисциплін - " + st.getCourseCount());
    }
}
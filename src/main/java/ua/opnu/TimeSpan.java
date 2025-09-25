package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    int getHours() {
        return hours;
    }

    int getMinutes() {
        return minutes;
    }

    TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            return; // ігноруємо, залишаємо попереднє значення
        }
        this.hours += hours;
        this.minutes += minutes;

        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }

    void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    double getTotalHours() {
        return hours + minutes / 60.0;
    }

    int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    void subtract(TimeSpan span) {
        int totalMinutes = getTotalMinutes();
        int subtractMinutes = span.getTotalMinutes();

        if (subtractMinutes > totalMinutes) {
            return; // ігноруємо, нічого не змінюємо
        }

        int resultMinutes = totalMinutes - subtractMinutes;

        this.hours = resultMinutes / 60;
        this.minutes = resultMinutes % 60;
    }

    void scale(int factor) {
        if (factor <= 0) {
            return; // ігноруємо
        }

        int totalMinutes = getTotalMinutes() * factor;

        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}
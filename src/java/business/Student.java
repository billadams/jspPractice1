package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Bill Adams
 */
public class Student implements Serializable {
    
    private String firstName;
    private String lastName;
    private Integer age = null;
    private String[] classes = null;
    private String color;
    private String[] hobbies = null;
    private LocalDate gradDate;
    
    public Student() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.classes = null;
        this.color = "";
        this.hobbies = null;
        this.gradDate = null;
    }
    
    public Student(String firstName, String lastName, int age, String[] classes, String color, String[] hobbies, LocalDate gradDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.classes = classes;
        this.color = color;
        this.hobbies = hobbies;
        this.gradDate = gradDate;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the classes
     */
    public String[] getClasses() {
        return classes;
    }

    /**
     * @param classes the classes to set
     */
    public void setClasses(String[] classes) {
        this.classes = classes;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the hobbies
     */
    public String[] getHobbies() {
        return hobbies;
    }

    /**
     * @param hobbies the hobbies to set
     */
    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * @return the gradDate
     */
    public LocalDate getGradDate() {
        return gradDate;
    }

    /**
     * @param gradDate the gradDate to set
     */
    public void setGradDate(LocalDate gradDate) {
        this.gradDate = gradDate;
    }
    
    public String formatGraduationDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        String gradDateFormatted = dtf.format(this.getGradDate());
        
        return gradDateFormatted;
    }
    
    public int daysUntilGraduation() {
        LocalDate today = LocalDate.now();
        int daysUntilGraduation = (int) ChronoUnit.DAYS.between(today, this.getGradDate());
      
        return daysUntilGraduation;
    }
}

import model.Project;
import model.Status;
import model.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
public class Test {

 // variables and constructor
    String title = "Watering flowers";

    String date = "20-10-2222";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate localDate = LocalDate.parse(date, formatter);

    Project project = new Project("project no.1");
    Status status = Status.Done;

    Task task1 = new Task(title, localDate, project, status);

    //Title Test:
    @org.junit.jupiter.api.Test
    public void getTitleTest() {
        assertEquals(title, task1.getTitle());
        assertNotEquals("hello", task1.getTitle());
        assertNotEquals("", task1.getTitle());
   }
     @org.junit.jupiter.api.Test
       void setTitleTest() {
        String newTitle = "Buying flowers";
        task1.setTitle(newTitle);
        assertEquals(newTitle,task1.getTitle());
    }

   //Date Test:
   @org.junit.jupiter.api.Test
    public void getDateTest(){
        assertEquals(localDate, task1.getDate());
        LocalDate date2 = LocalDate.parse("20-11-2020",formatter);
        assertNotEquals(date2, task1.getDate());
        assertNotEquals("hello", task1.getDate());
    }
   @org.junit.jupiter.api.Test
    public void setDateTest() {
       LocalDate date1 = LocalDate.parse("12-11-2323", formatter);
       task1.setDate(date1);
        assertEquals(date1,task1.getDate());
    }

  // Project Name Test:
    @org.junit.jupiter.api.Test
    public void getProjectTest(){
        assertEquals(project, task1.getProject());
        assertNotEquals(123,task1.getProject());
        assertNotEquals("",task1.getProject());
    }
    @org.junit.jupiter.api.Test
    public void setProjectTest() {
        Project project2 = new Project("project no.2");
        task1.setProject(project2);
        assertEquals(project2,task1.getProject());
    }

   // Status Test
    @org.junit.jupiter.api.Test
    public void getStatusTest() {
        assertEquals(status,task1.getStatus());
        assertNotEquals("hello", task1.getStatus());
        assertNotEquals(5,task1.getStatus());
   }
   @org.junit.jupiter.api.Test
    public void setStatusTest() {
        Status status1 = Status.Done;
        task1.setStatus(status1);
        assertEquals(status1,task1.getStatus());
    }
}

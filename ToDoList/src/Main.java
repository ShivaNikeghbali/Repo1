import model.Project;
import model.Task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        GroupOfTask groupOfTask = new GroupOfTask();
        String dateString = "22-02-2009";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        LocalDate localDate2 = LocalDate.parse("22-02-2005", formatter);



        groupOfTask.addTask(new Task("first", LocalDate.now(), new Project("dummy project")));
        groupOfTask.addTask(new Task("second", localDate, new Project("dummy project")));
        groupOfTask.addTask(new Task("third", localDate2, new Project("dummy project")));
//        System.out.println("adding tasks to list is done:\n--------------------------------------------------------");
//        groupOfTask.showAll();
        //TODO test this sorting, find a way to sort using streams

//        groupOfTask.saveList();
        groupOfTask.loadList();
        groupOfTask.showAll();
        System.out.println("-------------------");
        groupOfTask.sortTaskByDate();


    }
}


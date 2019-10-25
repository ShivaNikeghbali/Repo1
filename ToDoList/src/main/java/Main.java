import model.Project;
import model.Status;
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

//     GroupOfTask groupOfTask = new GroupOfTask();
//     String dateString = "22-02-2009";
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//      LocalDate localDate = LocalDate.parse(dateString, formatter);
//        LocalDate localDate2 = LocalDate.parse("22-02-2005", formatter);
//
//
//
//        groupOfTask.addTask(new Task("first", LocalDate.now(), new Project("ddummy project")));
//        groupOfTask.addTask(new Task("second", localDate, new Project("adummy project")));
//        groupOfTask.addTask(new Task("third", localDate2, new Project("fdummy project")));
//        groupOfTask.addTask(new Task("fourth", localDate2, new Project("my project"), Status.Done));
//        System.out.println("adding tasks to list is done:\n--------------------------------------------------------");
//        groupOfTask.showAll(groupOfTask.getList());
//
//
//        groupOfTask.saveList();
//        groupOfTask.loadList();
//        System.out.println("Show the list: ");
//        groupOfTask.showAll(groupOfTask.getList());
//        System.out.println("-------------------");
//
//        System.out.println("Sorting by date: ");
//        groupOfTask.sortTaskByDate();
//        System.out.println("-------------------");
//
//        System.out.println("Sorting by project name: ");
//        groupOfTask.sortTaskByProject();

  //      groupOfTask.saveList();

        Ui ui = new Ui();
        ui.greet();
    }
}


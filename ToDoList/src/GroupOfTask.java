import model.Task;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class GroupOfTask implements Serializable
{
    private static final String PATH = "/Users/shivanike/Desktop/ToDoList/src/data";
    private ArrayList<Task> list = new ArrayList<>();

    //add method (that add a task to list)
    //print all element in the list (taskList)
    // remove specific eleemtn or task from the list

    public static void show(Date date, String project) {

        //sort by date
        // sort by project
    }

    public static void add() {

//
//       Scanner scanner = new Scanner(System.in);
//       System.out.println("Write title you want to add: ");
//       String title = scanner.nextLine();
//       System.out.println("Enter the date: ");
//       String dateStr = scanner.nextLine();
//       Date date = new  SimpleDateFormat("MM/dd/yyyy").parse(dateStr);
//       System.out.println("Enter the name of the project");
//       String project = scanner.nextLine();
//
//       Task task = new Task(title,date,project);
//       list.add(task);
    }

    public static void remove() {

//       Scanner scanner = new Scanner(System.in);
//       System.out.println("Write title you want to remove: ");
//       String answer = scanner.nextLine();
//       Scanner scanner2 = new Scanner(System.in);
//       System.out.println("Enter the date: ");
//       Scanner dateStr = new Scanner(System.in);
//       String answer2 = scanner.nextLine();
//       System.out.println("Enter the name of the project");
//       String answer3 = scanner.nextLine();
//


    }

    public boolean addTask(Task task) {
        return list.add(task);
    }

    public boolean removeTask(Task task) {
        return list.remove(task);
    }

    public void showAll() {
        int i = 1;
        for (Task task : list) {
            System.out.println(i + ")  " + task);
            i++;
        }
    }

    public void sortTask() {

    }

    public void sortTaskBySate()
    {
        Collections.sort(list);
        showAll();
        //                                 return this.getDate().compareTo(otherTask.getDate());
        //list.stream().sorted((task1, task2) -> task1.getDate().compareTo(task2.getDate()));
    }

    public void saveList() {
        try {
            FileOutputStream fout = new FileOutputStream(PATH);
            ObjectOutputStream objectOut = new ObjectOutputStream(fout);
            objectOut.writeObject(list);
            fout.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void loadList() {
        try {
            FileInputStream fis = new FileInputStream(PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            list = (ArrayList<Task>) o;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}



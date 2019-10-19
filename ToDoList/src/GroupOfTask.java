import model.Task;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GroupOfTask implements Serializable
{
    private static final String PATH = "/Users/shivanike/Desktop/github/Repo1/ToDoList/src/data";
    private ArrayList<Task> list = new ArrayList<>();

    public ArrayList<Task> getList() {
        return list;
    }


    public static void show(Date date, String project) {}

        // sort by project

   // add new tasks to the list
    public boolean addTask(Task task) {
        return list.add(task);

    }

    // remove tasks from list
    public boolean removeTask(Task task) {
        return list.remove(task);

    }

    // To show all the tasks which are in the list
    public void showAll(List<Task> list) {
        int i = 1;
        for (Task task : list) {
            System.out.println(i + ")  " + task);
            i++;
        }
    }

    public void sortTask() {

    }
    // sort tasks by date
    public void sortTaskByDate()
    {
        //Collections.sort(list);
        //showAll();

        list.stream().sorted(Comparator.comparing(Task::getDate));
        showAll(this.list);
    }

    public void sortTaskByProject(){

        List newList = list.stream().sorted(Comparator.comparing(task -> task.getProject().getName())).collect(Collectors.toList());
        showAll(newList);

    }

    // To save whatever we have done with the list
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

    // To load whatever we want from the list
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



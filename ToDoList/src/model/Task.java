package model;

import java.io.Serializable;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;

public class Task implements Serializable, Comparable
{
    private String title;
    private LocalDate date;
    private Project project;
    private Status status;

    public Task(String title, LocalDate date, Project project) {
        this.title = title;
        this.date = date;
        this.project = project;
        this.status = Status.Not_Done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", project=" + project +
                ", status=" + status +
                '}';
    }

    @Override
    public int compareTo(Object o)
    {
        Task otherTask = (Task) o;
        return this.getDate().compareTo(otherTask.getDate());
    }
}

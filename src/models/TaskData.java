package models;

import models.Task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unAssignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unAssignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unAssignedTasks=unAssignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {

        return carolsTasks;
    }

    public Set<Task> getUnAssignedTasks() {
        return unAssignedTasks;
    }

    public Set<Task> getTasks(String param) {
        if (param.equals("ann")) {
            return annsTasks;
        } else if (param.equals("bob")) {
            return bobsTasks;
        } else if (param.equals("carol")) {
            return carolsTasks;
        } else {
            ArrayList<Set<Task>> newTask = new ArrayList<>();
            newTask.add(annsTasks);
            newTask.add(bobsTasks);
            newTask.add(carolsTasks);
            return getUnion(newTask);
        }
    }

    public Set<Task> getUnion(ArrayList<Set<Task>> setList) {
        Set<Task> newTask = new HashSet<>();

        for (Set<Task> set : setList) {
            newTask.addAll(set);
        }
        return newTask;
    }

    public Set<Task> getIntersect(Set<Task> task1, Set<Task> task2) {
        Set<Task> newTask = new HashSet<>(task1);
        newTask.retainAll(task2);
        return newTask;

    }

    public Set<Task> getDifference(Set<Task> task1, Set<Task> task2) {
        Set<Task> newTask = new HashSet<>(task1);
        newTask.removeAll(task2);
        return newTask;
    }
}

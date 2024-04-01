import models.Priority;
import models.Status;
import models.Task;
import models.TaskData;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Task> annsTask= new HashSet<>();
        Task annsTask1=new Task("A projesi","A projesi aciklama","ann", Priority.HIGH, Status.IN_PROGRESS);
        annsTask.add(annsTask1);
        Set<Task> bobsTask= new HashSet<>();
        Task bobsTask1=new Task("B projesi","B projesi aciklama","bob", Priority.LOW, Status.ASSIGNED);
        bobsTask.add(bobsTask1);
        Task bobsTask2=new Task("A projesi","A projesi aciklama","bob", Priority.LOW, Status.ASSIGNED);
        bobsTask.add(bobsTask2);
        Set<Task> carolsTask= new HashSet<>();
        Task carolsTask1=new Task("D projesi","D projesi aciklama","carol", Priority.LOW, Status.ASSIGNED);
        carolsTask.add(carolsTask1);

        Set<Task> unAssignedTask= new HashSet<>();
        Task unAssignedTask1=new Task("D2 projesi","D2 projesi aciklama",null, Priority.LOW, Status.IN_QUEUE);
        unAssignedTask.add(unAssignedTask1);

        Set<Task> allTasks=new HashSet<>();
        allTasks.add(annsTask1);
        allTasks.add(bobsTask1);
        allTasks.add(bobsTask2);
        allTasks.add(carolsTask1);
        allTasks.add(unAssignedTask1);

        TaskData taskData=new TaskData(annsTask,bobsTask,carolsTask,unAssignedTask);
        Set<Task> unionTask=taskData.getTasks("all");

        System.out.println("All tasks:" + unionTask);
        System.out.println("Ann's tasks:" + taskData.getTasks("ann"));
        System.out.println("Bob's tasks:" + taskData.getTasks("bob"));
        System.out.println("Carol's tasks:" + taskData.getTasks("carol"));
        System.out.println("Unassigned tasks:" + taskData.getDifference(allTasks,unionTask));
        System.out.println(taskData.getIntersect(annsTask,bobsTask));
        //System.out.println(taskData.getDifference(annsTask,bobsTask));

    }
}
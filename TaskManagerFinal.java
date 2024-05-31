public class TaskManagerFinal {

    static class Task {
        private String title;
        private String description;
        private boolean completed;
        private Task next;

        public Task(String title, String description) {
            this.title = title;
            this.description = description;
            this.completed = false;
            this.next = null;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void markCompleted() {
            this.completed = true;
        }

        public Task getNext() {
            return next;
        }

        public void setNext(Task next) {
            this.next = next;
        }
    }

    static class ToDoList {
        private Task head;

        public ToDoList() {
            this.head = null;
        }

        public void addTask(Task task) {
            if (head == null) {
                head = task;
            } else {
                Task current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(task);
            }
        }

        public void markTaskAsCompleted(String title) {
            Task current = head;
            while (current != null) {
                if (current.getTitle().equals(title)) {
                    current.markCompleted();
                    return;
                }
                current = current.getNext();
            }
            System.out.println("Task with title \"" + title + "\" not found.");
        }

        public void viewToDoList() {
            Task current = head;
            while (current != null) {
                String status = current.isCompleted() ? "Done" : "Not Done";
                System.out.println("Title: " + current.getTitle() + ", Description: " + current.getDescription() +
                        ", Completed: " + status);
                current = current.getNext();
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of ToDoList
        ToDoList toDoList = new ToDoList();

        // Add tasks to the ToDoList
        Task task1 = new Task("Read Books", "'Harry Potter', 'Pride and Prejudice'");
        Task task2 = new Task("Study", "Biology, Math");
        Task task3 = new Task("House Chores", "Do laundry, Mop floor, Cook dinner");
        Task task4 = new Task("Watch Movies", "'Titanic', 'Rango'");

        toDoList.addTask(task1);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
        toDoList.addTask(task4);

        // View the initial To-Do List
        System.out.println("Initial To-Do List:");
        toDoList.viewToDoList();

        // Mark a task as completed
        toDoList.markTaskAsCompleted("Read Books");
        toDoList.markTaskAsCompleted("Study");
        toDoList.markTaskAsCompleted("House Chores");
        toDoList.markTaskAsCompleted("Watch Movies");

        // Try to mark a non-existent task as completed
        toDoList.markTaskAsCompleted("Non-existent task");

        // Add a new task to the list
        Task task5 = new Task("Travel", "France, Japan, South Africa");
        toDoList.addTask(task5);

        // Display the updated To-Do List
        System.out.println("\nUpdated To-Do List:");
        toDoList.viewToDoList();

        // Mark other tasks as completed

        // View the final To-Do List
        System.out.println("\nFinal To-Do List:");
        toDoList.viewToDoList();
    }
}
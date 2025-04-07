
// TASK MANAGER - This class manage all the database operations

package model

import helperFunctions.printConfirmationCard
import helperFunctions.printTasksTable


class TaskManager {
    // Creating a List of Tasks
    // Calling Mock Data base
    // Assigning returned values to the Current List.
    private val tasks: MutableList<Task> = getMockTasks().toMutableList()

    // Function to add a task
    fun addTask(title: String, description: String) {
        // Confirmation check
        if (printConfirmationCard("add")) {
            tasks.add(Task(title, description))
            println("✅ Task added successfully!")
        } else {
            println("❌ Operation canceled.")
        }

    }

    // Function to delete a task
    fun removeTask(index: Int) {
        if (index >= 0 && index < tasks.size) {
            // Confirmation check
            if (printConfirmationCard("delete")) {
                tasks.removeAt(index)
                println("✅ Task deleted successfully!")
            } else {
                println("❌ Operation canceled.")
            }
        } else {
            println("❌ Invalid index task")
        }
    }

    // Function to list all the tasks
    fun listTasks() {
        if (tasks.isEmpty()) {
            println("✋ There are no tasks to show.")
        } else {
              printTasksTable(tasks)
        }
    }

    // Function to mark a task as done
    fun markTaskAsDone(index: Int) {
        if (index >= 0 && index < tasks.size) {
            if (printConfirmationCard("done")) {
                tasks[index] = Task(tasks[index].title, tasks[index].description, true)
                println("✅ Task marked as done successfully!")
            } else {
                println("❌ Operation canceled.")
            }
        } else {
            println("❌ Invalid index task.")
        }
    }
}

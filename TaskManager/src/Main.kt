// Welcome message - send to a helper function
import helperFunctions.welcome

import model.TaskManager

fun main() {
        // Calling welcome function.
        welcome()
        // Creating an instance of TaskManager
        val taskManager = TaskManager()
        // Creating a menu loop
        while (true) {
            println("1. Add a Task")
            println("2. Delete a Task")
            println("3. List all Tasks")
            println("4. Mark a Task as done")
            println("5. Exit")

            print("Enter your option: ")
            val option = readLine()!!

            when (option) {
                "1" -> {
                    print("Enter a title task: ")
                    val title = readLine()!!
                    print("Enter a description task: ")
                    val description = readLine()!!
                    taskManager.addTask(title, description)
                }
                "2" -> {
                    print("Enter the índex of the task to delete: ")
                    val index = readLine()!!.toInt() - 1
                    taskManager.removeTask(index)
                }
                "3" -> taskManager.listTasks()
                "4" -> {
                    print("Enter the índex of the task to mark as done: ")
                    val index = readLine()!!.toInt() - 1
                    taskManager.markTaskAsDone(index)
                }
                "5" -> break
                else -> println("Invalid option. Please, try again.")
            }
        }
    }